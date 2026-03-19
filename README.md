# Hệ thống Quản lý Sinh viên

Demo ứng dụng CI/CD với Spring Boot, Thymeleaf, Docker, GitHub Actions và Render

## Đề tài thực tập
**Nghiên cứu và triển khai quy trình CI/CD cho ứng dụng Web sử dụng Git và GitHub Actions**

Trường Đại học Trà Vinh - Phòng Công nghệ Thông tin

## Công nghệ sử dụng

- **Backend**: Java 21+, Spring Boot 3.2
- **Frontend**: Thymeleaf, HTML/CSS
- **Database**: H2 (dev), PostgreSQL (production)
- **Containerization**: Docker, Docker Compose
- **CI/CD**: GitHub Actions
- **Deployment**: Render

## Quy trình CI/CD

### 1. Git Workflow
```
feature branch → Pull Request → Code Review → Merge to main → Auto Deploy
```

### 2. CI Pipeline (Continuous Integration)
Trigger: Push hoặc Pull Request vào branch `main` hoặc `develop`

**Các bước:**
- Checkout code
- Setup JDK 17
- Build với Maven
- Chạy unit tests
- Package application (.jar)
- Upload artifacts

### 3. Docker Pipeline
Trigger: Push vào branch `main`

**Các bước:**
- Build Docker image (multi-stage)
- Push lên Docker Hub
- Tag theo version và SHA

### 4. CD Pipeline (Continuous Deployment)
Trigger: Push vào branch `main` (sau khi CI pass)

**Các bước:**
- Trigger Render deployment hook
- Render tự động pull code và deploy

## Cài đặt và Chạy Local

### Yêu cầu
- JDK 21+
- Maven 3.6+
- Docker (optional)

### Chạy với Maven
```bash
mvn spring-boot:run
```

Truy cập: http://localhost:8080

### Chạy với Docker
```bash
docker-compose up --build
```

### Chạy tests
```bash
mvn test
```

## Cấu hình GitHub Actions

### Secrets cần thiết:

1. **DOCKER_USERNAME**: Username Docker Hub của bạn
2. **DOCKER_PASSWORD**: Password hoặc Access Token Docker Hub
3. **RENDER_DEPLOY_HOOK_URL**: Deploy hook URL từ Render

### Cách thêm Secrets:
1. Vào repository GitHub → Settings → Secrets and variables → Actions
2. Click "New repository secret"
3. Thêm từng secret ở trên

## Deploy lên Render

### Bước 1: Tạo Web Service trên Render
1. Đăng nhập Render.com
2. New → Web Service
3. Connect GitHub repository
4. Cấu hình:
   - **Name**: student-management
   - **Environment**: Docker
   - **Branch**: main
   - **Plan**: Free

### Bước 2: Thêm Environment Variables
```
SPRING_PROFILES_ACTIVE=prod
DATABASE_URL=<postgres-url-if-needed>
```

### Bước 3: Lấy Deploy Hook
1. Settings → Deploy Hook
2. Copy URL và thêm vào GitHub Secrets

## Cấu trúc Project

```
student-management/
├── .github/
│   └── workflows/
│       ├── ci.yml              # CI Pipeline
│       ├── docker.yml          # Docker Build & Push
│       └── deploy.yml          # Deploy to Render
├── src/
│   ├── main/
│   │   ├── java/vn/edu/tvu/
│   │   │   ├── controller/     # Controllers
│   │   │   ├── model/          # Entities
│   │   │   ├── repository/     # JPA Repositories
│   │   │   ├── service/        # Business Logic
│   │   │   └── StudentManagementApplication.java
│   │   └── resources/
│   │       ├── templates/      # Thymeleaf views
│   │       └── application.properties
│   └── test/                   # Unit tests
├── Dockerfile                  # Multi-stage Docker build
├── docker-compose.yml          # Local development
├── pom.xml                     # Maven dependencies
└── README.md
```

## Tính năng

- ✅ Thêm sinh viên mới
- ✅ Xem danh sách sinh viên
- ✅ Sửa thông tin sinh viên
- ✅ Xóa sinh viên
- ✅ Validation form
- ✅ Responsive UI

## Demo CI/CD Flow

1. **Developer** tạo feature branch và code
2. **Push** code lên GitHub
3. **GitHub Actions** tự động:
   - Build project
   - Run tests
   - Build Docker image
   - Deploy lên Render
4. **Render** tự động cập nhật ứng dụng
5. **User** truy cập ứng dụng với version mới

## Liên hệ

Sinh viên thực tập - Trường ĐH Trà Vinh
