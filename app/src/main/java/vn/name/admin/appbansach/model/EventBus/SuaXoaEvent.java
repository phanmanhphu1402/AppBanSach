package vn.name.admin.appbansach.model.EventBus;

import vn.name.admin.appbansach.model.SanPhamMoi;

public class SuaXoaEvent {
    SanPhamMoi sanPhamMoi;

    public SanPhamMoi getSanPhamMoi() {
        return sanPhamMoi;
    }

    public void setSanPhamMoi(SanPhamMoi sanPhamMoi) {
        this.sanPhamMoi = sanPhamMoi;
    }

    public SuaXoaEvent(SanPhamMoi sanPhamMoi) {
        this.sanPhamMoi = sanPhamMoi;
    }
}
