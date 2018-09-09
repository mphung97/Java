package oop;

import java.util.Objects;

public class SinhVien {
    private String mssv;
    private String ho;
    private String ten;
    private String gioiTinh;
    private float ctdl;
    private float java;
    private float lthdt;
    private float mang;

    public SinhVien() {
    }

    public SinhVien(String mssv, String ho, String ten, String gioiTinh, float ctdl, float java, float lthdt, float mang) {
        this.mssv = mssv;
        this.ho = ho;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.ctdl = ctdl;
        this.java = java;
        this.lthdt = lthdt;
        this.mang = mang;
    }

    public SinhVien(String ho, String ten, String gioiTinh, float ctdl, float java, float lthdt, float mang) {
        this.ho = ho;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.ctdl = ctdl;
        this.java = java;
        this.lthdt = lthdt;
        this.mang = mang;
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        if (mssv == null && mssv.equals(""))
            this.mssv = "mssv";
        this.mssv = mssv;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public float getCtdl() {
        return ctdl;
    }

    public void setCtdl(float ctdl) {
        if (ctdl < 0)
            this.ctdl = 0;
        else if (ctdl > 10)
            this.ctdl = 10;
        else
            this.ctdl = ctdl;
    }

    public float getJava() {
        return java;
    }

    public void setJava(float java) {
        if (java < 0)
            this.java = 0;
        else if (java > 10)
            this.java = 10;
        else
            this.java = java;
    }

    public float getLthdt() {
        return lthdt;
    }

    public void setLthdt(float lthdt) {
        if (lthdt < 0)
            this.lthdt = 0;
        else if (lthdt > 10)
            this.lthdt = 10;
        else
            this.lthdt = lthdt;
    }

    public float getMang() {
        return mang;
    }

    public void setMang(float mang) {
        if (mang < 0)
            this.mang = 0;
        else if (mang > 10)
            this.mang = 10;
        else
            this.mang = mang;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SinhVien sinhVien = (SinhVien) o;
        return Objects.equals(mssv, sinhVien.mssv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mssv);
    }

    public float diemTB() {
        return ((ctdl + java + lthdt + mang) / 4);
    }

    public String xepLoai() {
        if (diemTB() >= 8.0f)
            return "Gioi";
        return "Chua Gioi";
    }

    public float getDiemNN() {
        float diemNN = 10.0f;
        if (diemNN > ctdl)
            diemNN = ctdl;
        if (diemNN > java)
            diemNN = java;
        if (diemNN > lthdt)
            diemNN = lthdt;
        if (diemNN > mang)
            diemNN = mang;
        return diemNN;
    }

    public boolean isDiemLiet() {
        return getDiemNN() < 3.0f;
    }

    public boolean isKhenThuong() {
        return ((diemTB() > 8.0f) && (getDiemNN() > 3.0f));
    }

    @Override
    public String toString() {
        return "{" +
                "mssv='" + mssv + '\'' +
                ", ho ten='" + ho + " " + ten + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", ctdl=" + ctdl +
                ", java=" + java +
                ", lthdt=" + lthdt +
                ", mang=" + mang +
                ", diemTB=" + diemTB() +
                '}';
    }
}
