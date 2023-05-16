package vn.name.admin.appbansach.model.EventBus;

import vn.name.admin.appbansach.model.SanPhamMoi;
import vn.name.admin.appbansach.model.User;

public class SuaXoaEvent {
    SanPhamMoi sanPhamMoi;
    User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public SanPhamMoi getSanPhamMoi() {
        return sanPhamMoi;
    }

    public void setSanPhamMoi(SanPhamMoi sanPhamMoi) {
        this.sanPhamMoi = sanPhamMoi;
    }

    public SuaXoaEvent(SanPhamMoi sanPhamMoi) {
        this.sanPhamMoi = sanPhamMoi;
    }
    public SuaXoaEvent(User user){
        this.user = user;
    }
}
