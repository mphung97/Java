package oop;

import java.text.DecimalFormat;
import java.util.Random;

public class DanhSachSinhVien {
    private SinhVien dssv[];
    private int soPhanTu = 0;

    public DanhSachSinhVien(int n) {

        if (n > 0)
            dssv = new SinhVien[n];
        else
            dssv = new SinhVien[1];
    }


    public void init() {
        Random rd = new Random();
        DecimalFormat df = new DecimalFormat("00000");

        String[] dsho = {"Nguyễn", "Trần", "Lữ", "Huỳnh", "Lê", "Phan"};
        String[] gioiTinh = {"Nam", "Nữ"};
        String strTen = "An , Anh , Bình , Bảo , Chánh , Cường , Duy , Dũng , Giang , Giáp , Hiếu , Hiệp , Hoan, Hoàn , Huy , Hân , Hùng , Hưng , Hường , Hạ , Hải , Hậu , Kha , Khang , Khánh , Khải , Kim , Kiện, Lai , Luân , Lân , Minh , Mạnh , Nam , Nghĩa , Nguyên , Nhàn , Nhân , Nhựt , Ny , Phi , Phong , Phát, Phúc, Phương, Quang, Quân, Quốc, Sang, Sách, Sơn, Thao, Thiên, Thiêng, Thiện, Thọ , Thành , Thông , Thương , Thạnh , Thảo , Thắng , Thịnh , Thọ , Tiến , Trí , Trường , Tuyết , Tuyền , Tuân , Tuấn , Tài , Tâm , Tân , Tùng , Tú , Tới , Tự , Vi , Vinh , Việt , Vĩ , Vũ , Vượng , Vửng , Xương , Ân , Đạt , Đức";
        String[] listName = strTen.split(",\\s");

        for (int i = 0; i < 10; i++) {
            SinhVien sv = new SinhVien();
            // Random điểm oop , ctdl , pplt và , ktmt;
            int ctdl = rd.nextInt(10) + 3;
            sv.setCtdl(ctdl);
            int java = rd.nextInt(10) + 3;
            sv.setJava(java);
            int lthdt = rd.nextInt(10) + 3;
            sv.setLthdt(lthdt);
            int mang = rd.nextInt(10) + 3;
            sv.setMang(mang);


            String ho = dsho[rd.nextInt(dsho.length)];
            sv.setHo(ho);
            String gt = gioiTinh[rd.nextInt(2)];
            sv.setGioiTinh(gt);
            String ten = listName[rd.nextInt(listName.length)];
            sv.setTen(ten);

            themSinhVien(sv);
        }
        System.out.println(soPhanTu);
        System.out.println(dssv.length);
    }

    public void inDanhSachSinhVien() {
        for (int i = 0; i < soPhanTu; i++)
            System.out.println(dssv[i]);
    }

    public int getSoSinhVienKhenThuong() {
        int count = 0;
        for (int i = 0; i < soPhanTu; i++) {
            if (dssv[i].isKhenThuong())
                count++;
        }
        return count;
    }

    public SinhVien[] getDSSVKhenThuong() {
        int n = getSoSinhVienKhenThuong();
        int j = 0;
        SinhVien[] dssvKhenThuong = new SinhVien[n];
        for (int i = 0; i < soPhanTu; i++) {
            if (dssv[i].isKhenThuong()) {
                dssvKhenThuong[j] = dssv[i];
                j++;
            }
        }
        return dssvKhenThuong;
    }

    public long getTongTienKhenThuong() {
        return getSoSinhVienKhenThuong() * 1000000;
    }

    public void sapXepDSSVByTen() {
        for (int i = 0; i < soPhanTu - 1; i++)
            for (int j = i + 1; j < soPhanTu; j++)
                if (dssv[i].getTen().compareTo(dssv[j].getTen()) > 0) {
                    SinhVien sv = dssv[i];
                    dssv[i] = dssv[j];
                    dssv[j] = sv;
                }
    }

    public void sapXepDSSVByDiemTB() {
        for (int i = 0; i < soPhanTu - 1; i++)
            for (int j = i + 1; j < soPhanTu; j++)
                if (dssv[i].diemTB() > dssv[j].diemTB()) {
                    SinhVien sv = dssv[i];
                    dssv[i] = dssv[j];
                    dssv[j] = sv;
                }
    }

    public boolean ktTrung(SinhVien sv1) {
        for (int i = 0; i < soPhanTu; i++) {
            if (dssv[i].equals(sv1))
                return true;
        }
        return false;
    }

    public SinhVien taoSV(SinhVien sv) {
        Random random = new Random();
        int rd = random.nextInt(15);
        DecimalFormat df = new DecimalFormat("00000");
        String mssv = df.format(rd);
        sv.setMssv(mssv);
        return sv;
    }

    public boolean themSinhVien(SinhVien sv) {
        sv = taoSV(sv);
        while (ktTrung(sv)) {
            sv = taoSV(sv);
        }
        if (soPhanTu == dssv.length)
            return false;
        else {
            dssv[soPhanTu] = sv;
            soPhanTu++;
        }
        return true;
    }

    public boolean xoaSinhVien(String mssv) {
        int i = 0, c = 0;
        for (c = i = 0; i < soPhanTu; i++) {
            if (!(dssv[i].getMssv().equals(mssv))) {
                dssv[c] = dssv[i];
                c++;
            }
        }
        if (c != i) {
            soPhanTu--;
            return true;
        }
        return false;
    }

    public boolean capNhatSinhVien(String mssv, SinhVien new_sv) {
        for (int i = 0; i < soPhanTu; i++) {
            if (dssv[i].getMssv().equals(mssv)) {
                dssv[i] = new_sv;
                return true;
            }
        }
        return false;
    }
}