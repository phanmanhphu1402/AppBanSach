package vn.name.admin.appbansach.utils;

import java.util.ArrayList;
import java.util.List;

import vn.name.admin.appbansach.model.GioHang;
import vn.name.admin.appbansach.model.User;

public class Utils {
    public static final String BASE_URL="http://192.168.1.5/bansach1/";
    public static List<GioHang> manggiohang;
    public static User user_curren;
    public static List<GioHang> mangmuahang = new ArrayList<>();
    public static User user_current = new User();
    public static String ID_RECEIVED;
    public static final String SENDID = "idsend";
    public static final String RECEIVEDID = "idreceived";
    public static final String MESS = "message";
    public static final String DATETIME = "datetime";
    public static final String PATH_CHAT = "chat";
}
