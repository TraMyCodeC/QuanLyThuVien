/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Pojo;
import com.mycompany.config.Ultils;
import java.time.LocalDateTime;

/**
 *
 * @author My
 */
public class Sach {
    private int maSach,maDanhMuc;
    private String tenSach,tacGia,noiXB,moTa,viTri;
    private LocalDateTime namXB,ngayNhap;

    public Sach(int maSach,String tenSach, String tacGia,String moTa, String noiXB, LocalDateTime namXB, int maDanhMuc,LocalDateTime ngayNhap, String Vitri) {
        this.maSach = maSach;
        this.maDanhMuc = maDanhMuc;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.noiXB = noiXB;
        this.moTa = moTa;
        this.viTri = Vitri;
        this.namXB = namXB;
        this.ngayNhap = ngayNhap;
    }

    /**
     * @return the maSach
     */
    public int getMaSach() {
        return maSach;
    }

    /**
     * @param maSach the maSach to set
     */
    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    /**
     * @return the maDanhMuc
     */
    public int getMaDanhMuc() {
        return maDanhMuc;
    }
    public String getMaDM()
    {
        return Ultils.inToString(this.maDanhMuc);
    }

    /**
     * @param maDanhMuc the maDanhMuc to set
     */
    public void setMaDanhMuc(int maDanhMuc) {
        this.maDanhMuc = maDanhMuc;
    }

    /**
     * @return the tenSach
     */
    public String getTenSach() {
        return tenSach;
    }

    /**
     * @param tenSach the tenSach to set
     */
    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    /**
     * @return the tacGia
     */
    public String getTacGia() {
        return tacGia;
    }

    /**
     * @param tacGia the tacGia to set
     */
    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    /**
     * @return the noiXB
     */
    public String getNoiXB() {
        return noiXB;
    }

    /**
     * @param noiXB the noiXB to set
     */
    public void setNoiXB(String noiXB) {
        this.noiXB = noiXB;
    }

    /**
     * @return the moTa
     */
    public String getMoTa() {
        return moTa;
    }

    /**
     * @param moTa the moTa to set
     */
    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    /**
     * @return the Vitri
     */
    public String getViTri() {
        return viTri;
    }

    /**
     * @param Vitri the Vitri to set
     */
    public void setVitri(String Vitri) {
        this.viTri= Vitri;
    }

    /**
     * @return the namXB
     */
    public LocalDateTime getNamXB() {
        return namXB;
    }
   public String getNamXuat() {
        return Ultils.dateTimeFormatter(this.namXB);
    }
    /**
     * @param namXB the namXB to set
     */
    public void setNamXB(LocalDateTime namXB) {
        this.namXB = namXB;
    }

    /**
     * @return the ngayNhap
     */
    public LocalDateTime getNgayNhap() {
        return ngayNhap;
    }

    /**
     * @param ngayNhap the ngayNhap to set
     */
    public void setNgayNhap(LocalDateTime ngayNhap) {
        this.ngayNhap = ngayNhap;
    }
}
