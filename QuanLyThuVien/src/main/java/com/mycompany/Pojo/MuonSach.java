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
public class MuonSach {
    private int maDG,maSach;
    private LocalDateTime ngayMuon,ngayTra;
    private int tienPhat;
    public MuonSach(int madg,int masach,LocalDateTime ngayM,LocalDateTime ngayT,int tien)
    {
        this.maDG=madg;
        this.maSach=masach;
        this.ngayMuon=ngayM;
        this.ngayTra=ngayT;
        this.tienPhat=tien;
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
     * @return the ngayMuon
     */
    public LocalDateTime getNgayMuon() {
        return ngayMuon;
    }

    /**
     * @param ngayMuon the ngayMuon to set
     */
    public void setNgayMuon(LocalDateTime ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    /**
     * @return the ngayTra
     */
    public LocalDateTime getNgayTra() {
        return ngayTra;
    }

    /**
     * @param ngayTra the ngayTra to set
     */
    public void setNgayTra(LocalDateTime ngayTra) {
        this.ngayTra = ngayTra;
    }

    /**
     * @return the tienPhat
     */
    public int getTienPhat() {
        return tienPhat;
    }

    /**
     * @param tienPhat the tienPhat to set
     */
    public void setTienPhat(int tienPhat) {
        this.tienPhat = tienPhat;
    }
}
