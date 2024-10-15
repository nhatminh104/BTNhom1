public class HinhTron {
    private double banKinh;

    public HinhTron(double banKinh) {
        setBanKinh(banKinh);
    }

    public void setBanKinh(double banKinh) {
        if (banKinh > 0) {
            this.banKinh = banKinh;
        } else {
            throw new IllegalArgumentException("Bán kính phải lớn hơn 0.");
        }
    }

    public double getBanKinh() {
        return banKinh;
    }

    public double tinhChuVi() {
        return 2 * Math.PI * banKinh;
    }

    public double tinhDienTich() {
        return Math.PI * banKinh * banKinh;
    }

    public static void main(String[] args) {
        try {
            HinhTron hinhTron = new HinhTron(-1);
            System.out.println("Bán kính: " + hinhTron.getBanKinh());
            System.out.println("Chu vi: " + hinhTron.tinhChuVi());
            System.out.println("Diện tích: " + hinhTron.tinhDienTich());

            hinhTron.setBanKinh(-3);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}