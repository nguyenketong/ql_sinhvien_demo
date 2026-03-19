# Hướng dẫn Setup từ đầu

## Bước 1: Chuẩn bị môi trường

### Cài đặt công cụ cần thiết:
1. **JDK 21+**: https://adoptium.net/ (bạn đang dùng JDK 25 - OK!)
2. **Maven**: https://maven.apache.org/download.cgi
3. **Docker Desktop**: https://www.docker.com/products/docker-desktop
4. **Git**: https://git-scm.com/downloads

### Kiểm tra cài đặt:
```bash
java -version    # Phải là 21+
mvn -version     # Phải là 3.6+
docker --version
git --version
```

## Bước 2: Setup GitHub Repository

1. Tạo repository mới trên GitHub (public hoặc private)
2. Clone project này về local:
```bash
git clone <your-repo-url>
cd student-management
```

3. Push code lên GitHub:
```bash
git add .
git commit -m "Initial commit: Student Management System"
git push origin main
```

## Bước 3: Setup Docker Hub

1. Đăng ký tài khoản tại https://hub.docker.com
2. Tạo Access Token:
   - Account Settings → Security → New Access Token
   - Lưu token này (chỉ hiện 1 lần)

## Bước 4: Setup GitHub Secrets

Vào repository → Settings → Secrets and variables → Actions

Thêm 3 secrets:

1. **DOCKER_USERNAME**
   - Value: username Docker Hub của bạn

2. **DOCKER_PASSWORD**
   - Value: Access Token từ Docker Hub

3. **RENDER_DEPLOY_HOOK_URL**
   - Value: Sẽ lấy từ Render ở bước 5

## Bước 5: Setup Render

1. Đăng ký tại https://render.com (dùng GitHub account)

2. Tạo Web Service:
   - Dashboard → New → Web Service
   - Connect repository GitHub
   - Cấu hình:
     * **Name**: student-management
     * **Environment**: Docker
     * **Branch**: main
     * **Instance Type**: Free

3. Lấy Deploy Hook:
   - Vào service → Settings → Deploy Hook
   - Copy URL
   - Thêm vào GitHub Secrets (RENDER_DEPLOY_HOOK_URL)

## Bước 6: Test CI/CD Pipeline

### Test CI:
```bash
git checkout -b feature/test-ci
# Sửa code bất kỳ
git add .
git commit -m "test: CI pipeline"
git push origin feature/test-ci
```

Tạo Pull Request trên GitHub → CI sẽ chạy tự động

### Test CD:
Merge Pull Request vào main → CD sẽ deploy tự động

## Bước 7: Kiểm tra kết quả

1. **GitHub Actions**: Repository → Actions → Xem workflows
2. **Docker Hub**: Hub.docker.com → Repositories → Xem images
3. **Render**: Dashboard → Xem deployment logs
4. **App**: Truy cập URL Render cung cấp

## Troubleshooting

### Lỗi Maven build:
```bash
mvn clean install -U
```

### Lỗi Docker build local:
```bash
docker build -t student-management .
docker run -p 8080:8080 student-management
```

### GitHub Actions fail:
- Kiểm tra logs chi tiết trong Actions tab
- Verify secrets đã thêm đúng
- Check syntax trong workflow files

### Render deployment fail:
- Check logs trong Render dashboard
- Verify Dockerfile syntax
- Check environment variables
