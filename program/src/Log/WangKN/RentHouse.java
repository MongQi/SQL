package Log.WangKN;

import java.sql.Date;

public class RentHouse {
    private String Hid;
    private String Hlocation;
    private int Hfloor;
    private String Htype;
    private int Hcount;
    private float Hsquare;
    private float Hmoney;
    private float Hguarantee;
    private String Hprovince;
    private String Hcity;
    private String Harea;
    private Date Hdate;
    private String Hdescription;

    public RentHouse(String id, String location, int floor, String type,
                     int count, float money, float square, float guarantee,
                     String province, String city, String area, Date date, String description) {
        Hid = id;
        Hlocation = location;
        Hfloor = floor;
        Htype = type;
        Hmoney = money;
        Hsquare = square;
        Hprovince = province;
        Hcity = city;
        Harea = area;
        Hcount = count;
        Hguarantee = guarantee;
        Hdate = date;
        Hdescription = description;
    }

    public String getHdescription() {
        return Hdescription;
    }

    public String getHid() {
        return Hid;
    }

    public String getHlocation() {
        return Hlocation;
    }

    public int getHfloor() {
        return Hfloor;
    }

    public String getHtype() {
        return Htype;
    }

    public float getHmoney() {
        return Hmoney;
    }

    public float getHsquare() {
        return Hsquare;
    }

    public String getHprovince() {
        return Hprovince;
    }

    public String getHcity() {
        return Hcity;
    }

    public String getHarea() {
        return Harea;
    }

    public int getHcount() {
        return Hcount;
    }

    public float getHguarantee() {
        return Hguarantee;
    }

    public Date getHdate() {
        return Hdate;
    }
}
