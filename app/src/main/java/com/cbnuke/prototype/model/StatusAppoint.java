package com.cbnuke.prototype.model;

import java.util.List;

/**
 * Created by Amnart on 13/1/2560.
 */

public class StatusAppoint {

    /**
     * data : [{"app_id":"5","pat_hn":"HA1114","app_date":"2017-01-23","dep_id":"12","detail":"นัดมาใหม่","dep_name_th":"กุมารเวชกรรม","dep_name_en":"Pediatrics","dep_lat":null,"dep_long":null},{"app_id":"6","pat_hn":"HA1114","app_date":"2017-01-26","dep_id":"19","detail":"ส่งเอกสาร","dep_name_th":"บูรณาการ","dep_name_en":"VIP","dep_lat":null,"dep_long":null}]
     * status : success
     */

    private String status;
    private List<DataEntity> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public static class DataEntity {
        /**
         * app_id : 5
         * pat_hn : HA1114
         * app_date : 2017-01-23
         * dep_id : 12
         * detail : นัดมาใหม่
         * dep_name_th : กุมารเวชกรรม
         * dep_name_en : Pediatrics
         * dep_lat : null
         * dep_long : null
         */

        private String app_id;
        private String pat_hn;
        private String app_date;
        private String dep_id;
        private String detail;
        private String dep_name_th;
        private String dep_name_en;
        private String dep_lat;
        private String dep_long;

        public String getApp_id() {
            return app_id;
        }

        public void setApp_id(String app_id) {
            this.app_id = app_id;
        }

        public String getPat_hn() {
            return pat_hn;
        }

        public void setPat_hn(String pat_hn) {
            this.pat_hn = pat_hn;
        }

        public String getApp_date() {
            return app_date;
        }

        public void setApp_date(String app_date) {
            this.app_date = app_date;
        }

        public String getDep_id() {
            return dep_id;
        }

        public void setDep_id(String dep_id) {
            this.dep_id = dep_id;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public String getDep_name_th() {
            return dep_name_th;
        }

        public void setDep_name_th(String dep_name_th) {
            this.dep_name_th = dep_name_th;
        }

        public String getDep_name_en() {
            return dep_name_en;
        }

        public void setDep_name_en(String dep_name_en) {
            this.dep_name_en = dep_name_en;
        }

        public Object getDep_lat() {
            return dep_lat;
        }

        public void setDep_lat(String dep_lat) {
            this.dep_lat = dep_lat;
        }

        public Object getDep_long() {
            return dep_long;
        }

        public void setDep_long(String dep_long) {
            this.dep_long = dep_long;
        }
    }
}
