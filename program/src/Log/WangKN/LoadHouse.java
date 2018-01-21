package Log.WangKN;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoadHouse {
    private String sql;
    private List<RentHouse> rent;

    public void DeterSQL(String Province, String City, String Area,
                         String Acreage, String Bedroomcount, String State) {
//		整租
        if (State == "整租") {
            if (Acreage == "50平方米以下") {
                if (Bedroomcount == "一室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=false) and "
                            + "Hcount = 1 and Hsquare<50 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "两室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=false) and "
                            + "Hcount = 2 and Hsquare<50 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "三室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=false) and "
                            + "Hcount = 3 and Hsquare<50 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "四室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=false) and "
                            + "Hcount = 4 and Hsquare<50 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "五室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=false) and "
                            + "Hcount = 5 and Hsquare<50 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "五室以上") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=false) and "
                            + "Hcount > 5 and Hsquare<50 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                }
            } else if (Acreage == "50-70平方米") {
                if (Bedroomcount == "一室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=false) and "
                            + "Hcount = 1 and Hsquare between 50 and 70 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "两室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=false) and "
                            + "Hcount = 2 and Hsquare between 50 and 70 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "三室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=false) and "
                            + "Hcount = 3 and Hsquare between 50 and 70 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "四室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=false) and "
                            + "Hcount = 4 and Hsquare between 50 and 70 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "五室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=false) and "
                            + "Hcount = 5 and Hsquare between 50 and 70 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "五室以上") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=false) and "
                            + "Hcount > 5 and Hsquare between 50 and 70 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                }
            } else if (Acreage == "70-90平方米") {
                if (Bedroomcount == "一室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=false) and "
                            + "Hcount = 1 and Hsquare between 70 and 90 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "两室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=false) and "
                            + "Hcount = 2 and Hsquare between 70 and 90 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "三室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=false) and "
                            + "Hcount = 3 and Hsquare between 70 and 90 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "四室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=false) and "
                            + "Hcount = 4 and Hsquare between 70 and 90 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "五室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=false) and "
                            + "Hcount = 5 and Hsquare between 70 and 90 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "五室以上") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=false) and "
                            + "Hcount > 5 and Hsquare between 70 and 90 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                }
            } else if (Acreage == "90-110平方米") {
                if (Bedroomcount == "一室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=false) and "
                            + "Hcount = 1 and Hsquare between 90 and 110 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "两室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=false) and "
                            + "Hcount = 2 and Hsquare between 90 and 110 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "三室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=false) and "
                            + "Hcount = 3 and Hsquare between 90 and 110 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "四室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=false) and "
                            + "Hcount = 4 and Hsquare between 90 and 110 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "五室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=false) and "
                            + "Hcount = 5 and Hsquare between 90 and 110 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "五室以上") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=false) and "
                            + "Hcount > 5 and Hsquare between 90 and 110 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                }
            } else if (Acreage == "110-130平方米") {
                if (Bedroomcount == "一室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=false) and "
                            + "Hcount = 1 and Hsquare between 110 and 130 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "两室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=false) and "
                            + "Hcount = 2 and Hsquare between 110 and 130 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "三室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=false) and "
                            + "Hcount = 3 and Hsquare between 110 and 130 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "四室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=false) and "
                            + "Hcount = 4 and Hsquare between 110 and 130 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "五室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=false) and "
                            + "Hcount = 5 and Hsquare between 110 and 130 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "五室以上") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=false) and "
                            + "Hcount > 5 and Hsquare between 110 and 130 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                }
            } else if (Acreage == "130-150平方米") {
                if (Bedroomcount == "一室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=false) and "
                            + "Hcount = 1 and Hsquare between 130 and 150 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "两室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=false) and "
                            + "Hcount = 2 and Hsquare between 130 and 150 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "三室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=false) and "
                            + "Hcount = 3 and Hsquare between 130 and 150 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "四室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=false) and "
                            + "Hcount = 4 and Hsquare between 130 and 150 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "五室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=false) and "
                            + "Hcount = 5 and Hsquare between 130 and 150 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "五室以上") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=false) and "
                            + "Hcount > 5 and Hsquare between 130 and 150 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                }
            } else if (Acreage == "150-200平方米") {
                if (Bedroomcount == "一室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=false) and "
                            + "Hcount = 1 and Hsquare between 150 and 200 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "两室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=false) and "
                            + "Hcount = 2 and Hsquare between 150 and 200 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "三室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=false) and "
                            + "Hcount = 3 and Hsquare between 150 and 200 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "四室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=false) and "
                            + "Hcount = 4 and Hsquare between 150 and 200 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "五室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=false) and "
                            + "Hcount = 5 and Hsquare between 150 and 200 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "五室以上") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=false) and "
                            + "Hcount > 5 and Hsquare between 150 and 200 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                }
            } else if (Acreage == "200平方米以上") {
                if (Bedroomcount == "一室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=false) and "
                            + "Hcount = 1 and Hsquare > 200 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "两室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=false) and "
                            + "Hcount = 2 and Hsquare > 200 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "三室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=false) and "
                            + "Hcount = 3 and Hsquare > 200 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "四室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=false) and "
                            + "Hcount = 4 and Hsquare > 200 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "五室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=false) and "
                            + "Hcount = 5 and Hsquare > 200 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "五室以上") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=false) and "
                            + "Hcount > 5 and Hsquare > 200 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                }
            }
        } else if (State == "合租") {
            if (Acreage == "50平方米以下") {
                if (Bedroomcount == "一室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=true) and "
                            + "Hcount = 1 and Hsquare<50 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "两室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=true) and "
                            + "Hcount = 2 and Hsquare<50 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "三室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=true) and "
                            + "Hcount = 3 and Hsquare<50 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "四室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=true) and "
                            + "Hcount = 4 and Hsquare<50 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "五室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=true) and "
                            + "Hcount = 5 and Hsquare<50 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "五室以上") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=true) and "
                            + "Hcount > 5 and Hsquare<50 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                }
            } else if (Acreage == "50-70平方米") {
                if (Bedroomcount == "一室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=true) and "
                            + "Hcount = 1 and Hsquare between 50 and 70 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "两室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=true) and "
                            + "Hcount = 2 and Hsquare between 50 and 70 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "三室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=true) and "
                            + "Hcount = 3 and Hsquare between 50 and 70 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "四室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=true) and "
                            + "Hcount = 4 and Hsquare between 50 and 70 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "五室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=true) and "
                            + "Hcount = 5 and Hsquare between 50 and 70 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "五室以上") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=true) and "
                            + "Hcount > 5 and Hsquare between 50 and 70 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                }
            } else if (Acreage == "70-90平方米") {
                if (Bedroomcount == "一室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=true) and "
                            + "Hcount = 1 and Hsquare between 70 and 90 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "两室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=true) and "
                            + "Hcount = 2 and Hsquare between 70 and 90 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "三室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=true) and "
                            + "Hcount = 3 and Hsquare between 70 and 90 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "四室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=true) and "
                            + "Hcount = 4 and Hsquare between 70 and 90 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "五室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=true) and "
                            + "Hcount = 5 and Hsquare between 70 and 90 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "五室以上") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=true) and "
                            + "Hcount > 5 and Hsquare between 70 and 90 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                }
            } else if (Acreage == "90-110平方米") {
                if (Bedroomcount == "一室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=true) and "
                            + "Hcount = 1 and Hsquare between 90 and 110 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "两室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=true) and "
                            + "Hcount = 2 and Hsquare between 90 and 110 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "三室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=true) and "
                            + "Hcount = 3 and Hsquare between 90 and 110 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "四室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=true) and "
                            + "Hcount = 4 and Hsquare between 90 and 110 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "五室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=true) and "
                            + "Hcount = 5 and Hsquare between 90 and 110 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "五室以上") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=true) and "
                            + "Hcount > 5 and Hsquare between 90 and 110 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                }
            } else if (Acreage == "110-130平方米") {
                if (Bedroomcount == "一室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=true) and "
                            + "Hcount = 1 and Hsquare between 110 and 130 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "两室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=true) and "
                            + "Hcount = 2 and Hsquare between 110 and 130 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "三室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=true) and "
                            + "Hcount = 3 and Hsquare between 110 and 130 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "四室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=true) and "
                            + "Hcount = 4 and Hsquare between 110 and 130 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "五室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=true) and "
                            + "Hcount = 5 and Hsquare between 110 and 130 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "五室以上") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=true) and "
                            + "Hcount > 5 and Hsquare between 110 and 130 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                }
            } else if (Acreage == "130-150平方米") {
                if (Bedroomcount == "一室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=true) and "
                            + "Hcount = 1 and Hsquare between 130 and 150 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "两室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=true) and "
                            + "Hcount = 2 and Hsquare between 130 and 150 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "三室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=true) and "
                            + "Hcount = 3 and Hsquare between 130 and 150 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "四室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=true) and "
                            + "Hcount = 4 and Hsquare between 130 and 150 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "五室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=true) and "
                            + "Hcount = 5 and Hsquare between 130 and 150 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "五室以上") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=true) and "
                            + "Hcount > 5 and Hsquare between 130 and 150 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                }
            } else if (Acreage == "150-200平方米") {
                if (Bedroomcount == "一室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=true) and "
                            + "Hcount = 1 and Hsquare between 150 and 200 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "两室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=true) and "
                            + "Hcount = 2 and Hsquare between 150 and 200 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "三室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=true) and "
                            + "Hcount = 3 and Hsquare between 150 and 200 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "四室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=true) and "
                            + "Hcount = 4 and Hsquare between 150 and 200 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "五室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=true) and "
                            + "Hcount = 5 and Hsquare between 150 and 200 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "五室以上") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=true) and "
                            + "Hcount > 5 and Hsquare between 150 and 200 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                }
            } else if (Acreage == "200平方米以上") {
                if (Bedroomcount == "一室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=true) and "
                            + "Hcount = 1 and Hsquare > 200 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "两室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=true) and "
                            + "Hcount = 2 and Hsquare > 200 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "三室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=true) and "
                            + "Hcount = 3 and Hsquare > 200 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "四室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=true) and "
                            + "Hcount = 4 and Hsquare > 200 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "五室") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=true) and "
                            + "Hcount = 5 and Hsquare > 200 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                } else if (Bedroomcount == "五室以上") {
                    sql = "select * from House join Information on Hid=Iid "
                            + "where Hid in (select Iid from Information"
                            + " where Ijoint=true) and "
                            + "Hcount > 5 and Hsquare > 200 and "
                            + "Hprovince=\"" + Province + "\" and Hcity=\"" + City + "\" and Harea=\"" + Area
                            + "\"and Hstate=true";
                }
            }
        }
    }

    public void DBquery() {
        Statement stament = null;
        ResultSet result = null;
        rent = new ArrayList<RentHouse>();

        Connection con = ConnectionDB.ConDB("jdbc:mysql://47.94.250.207:3306/"
                + "renthouse?useUnicode=true&characterEncoding=utf8&useSSL=true");
        try {
            stament = con.createStatement();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("创建连接失败");
        }
        try {
            result = stament.executeQuery(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("查询失败");
        }
        try {
            while (result.next()) {
                String id = result.getString("Hid");
                String location = result.getString("Hlocation");
                int floor = result.getInt("Hfloor");
                String type = result.getString("Htype");
                float money = result.getFloat("Imoney");
                float square = result.getFloat("Hsquare");
                String province = result.getString("Hprovince");
                String city = result.getString("Hcity");
                String area = result.getString("Harea");
                int count = result.getInt("Hcount");
                float guarantee = result.getFloat("Iguarantee");
                Date date = result.getDate("Itime");
                String description = result.getString("Idescription");
                RentHouse house0 = new RentHouse(id, location, floor, type,
                        count, money, square, guarantee, province, city,
                        area, date, description);
                rent.add(house0);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            result.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            stament.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public List<RentHouse> getRent() {
        return rent;
    }
}
