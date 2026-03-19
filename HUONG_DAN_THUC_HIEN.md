# Hướng dẫn Thực hiện Demo CI/CD

## Tuần 4-5: Setup và Development (2 tuần)

### Ngày 1-2: Setup Project
- [x] Tạo repository GitHub
- [x] Clone project về local
- [x] Cài đặt JDK 17, Maven
- [x] Chạy thử ứng dụng local
- [x] Commit code lên GitHub

### Ngày 3-5: Phát triển tính năng
- [x] Hoàn thiện CRUD sinh viên
- [x] Viết unit tests
- [x] Test validation
- [x] Tạo Pull Request đầu tiên

### Ngày 6-7: Setup Docker
- [x] Viết Dockerfile (multi-stage build)
- [x] Test build Docker image local
- [x] Tạo docker-compose.yml
- [x] Đăng ký Docker Hub
- [x] Push image thử nghiệm

### Ngày 8-10: Setup GitHub Actions
- [x] Tạo CI workflow (build + test)
- [x] Tạo Docker workflow (build + push)
- [x] Thêm GitHub Secrets
- [x] Test workflows

## Tuần 6: Deployment và Hoàn thiện (1 tuần)

### Ngày 11-12: Deploy lên Render
- [ ] Đăng ký Render.com
- [ ] Tạo Web Service
- [ ] Cấu hình environment variables
- [ ] Deploy thử nghiệm
- [ ] Lấy Deploy Hook URL

### Ngày 13-14: Hoàn thiện CI/CD
- [ ] Tạo CD workflow (auto deploy)
- [ ] Test toàn bộ quy trình
- [ ] Fix bugs nếu có
- [ ] Tối ưu performance

### Ngày 15: Chuẩn bị báo cáo
- [ ] Chụp screenshots các bước
- [ ] Ghi lại logs CI/CD
- [ ] Viết tài liệu báo cáo
- [ ] Chuẩn bị slide thuyết trình

## Checklist Demo

### Git & GitHub
- [ ] Repository có cấu trúc rõ ràng
- [ ] Commit messages có ý nghĩa
- [ ] Có sử dụng branches
- [ ] Có Pull Requests
- [ ] README.md đầy đủ

### CI/CD Pipeline
- [ ] CI workflow chạy tự động khi push
- [ ] Tests pass
- [ ] Docker image build thành công
- [ ] Auto deploy khi merge vào main
- [ ] Có thể xem logs trên GitHub Actions

### Docker
- [ ] Dockerfile tối ưu (multi-stage)
- [ ] Image size hợp lý
- [ ] Container chạy được
- [ ] Push lên Docker Hub thành công

### Deployment
- [ ] Ứng dụng chạy trên Render
- [ ] Có public URL để truy cập
- [ ] Auto deploy khi có code mới
- [ ] Environment variables được cấu hình

## Tips cho Báo cáo

### Nội dung cần trình bày:
1. **Giới thiệu**: Đề tài, mục tiêu, công nghệ
2. **Lý thuyết**: CI/CD là gì, tại sao cần thiết
3. **Thiết kế**: Sơ đồ quy trình CI/CD
4. **Triển khai**: 
   - Cấu hình GitHub Actions
   - Dockerfile
   - Deploy strategy
5. **Demo**: Chạy thực tế quy trình
6. **Kết quả**: Screenshots, metrics
7. **Kết luận**: Ưu điểm, hạn chế, hướng phát triển

### Screenshots cần có:
- GitHub Actions workflows (success)
- Docker Hub images
- Render deployment logs
- Ứng dụng chạy trên production
- Pull Request với CI checks

## Lưu ý quan trọng

⚠️ **Render Free Plan**: App sẽ sleep sau 15 phút không hoạt động, khởi động lại mất ~1 phút

💡 **Demo tips**: 
- Chuẩn bị sẵn một Pull Request để demo
- Wake up Render app trước khi demo 5 phút
- Có backup video demo phòng khi mạng chập chờn
