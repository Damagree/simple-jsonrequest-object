package com.damagreed.volleyintro;

public class ListBarang {

    private String Barang, Harga, Qty;
    private int jumlah, ini;

    public ListBarang(String Barang, String Harga, String Qty){
        this.setBarang(Barang);
        this.setHarga(Harga);
        this.setQty(Qty);
    }


    public String getHarga() {
        return Harga;
    }

    public void setHarga(String harga) {
        Harga = harga;
    }

    public String getQty() {
        return Qty;
    }

    public void setQty(String qty) {
        Qty = qty;
    }

    public String getBarang() {
        return Barang;
    }

    public void setBarang(String barang) {
        Barang = barang;
    }
}
