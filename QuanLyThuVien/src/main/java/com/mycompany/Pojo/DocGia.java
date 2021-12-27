/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Pojo;

import java.time.LocalDateTime;

/**
 *
 * @author My
 */
public class DocGia {
        private int maDG;
    private String hoTen,gioiTinh,doiTuong;
    private LocalDateTime ngaySinh,hanThe;
    public DocGia(int maDG, String hoTen, String gioiTinh, String doiTuong, LocalDateTime ngaySinh, LocalDateTime hanThe) {
        this.maDG = maDG;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.doiTuong = doiTuong;
        this.ngaySinh = ngaySinh;
        this.hanThe = hanThe;
    }
    

    /**
     * @return the maDG
     */
    public int getMaDG() {
        return maDG;
    }

    /**
     * @param maDG the maDG to set
     */
    public void setMaDG(int maDG) {
        this.maDG = maDG;
    }

    /**
     * @return the hoTen
     */
    public String getHoTen() {
        return hoTen;
    }

    /**
     * @param hoTen the hoTen to set
     */
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    /**
     * @return the gioiTinh
     */
    public String getGioiTinh() {
        return gioiTinh;
    }

    /**
     * @param gioiTinh the gioiTinh to set
     */
    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    /**
     * @return the doiTuong
     */
    public String getDoiTuong() {
        return doiTuong;
    }

    /**
     * @param doiTuong the doiTuong to set
     */
    public void setDoiTuong(String doiTuong) {
        this.doiTuong = doiTuong;
    }

    /**
     * @return the ngaySinh
     */
    public LocalDateTime getNgaySinh() {
        return ngaySinh;
    }

    /**
     * @param ngaySinh the ngaySinh to set
     */
    public void setNgaySinh(LocalDateTime ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    /**
     * @return the hanThe
     */
    public LocalDateTime getHanThe() {
        return hanThe;
    }
}
