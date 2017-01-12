package com.cbnuke.prototype.model;

import java.util.List;

/**
 * Created by Amnart on 13/1/2560.
 */

public class StatusQueue {

    /**
     * data : [{"qd_id":"15","id_uni":"2","dep_id":"20","qd_order_number":null,"qd_date":"2017-01-12","qd_time":null,"qd_status":"register","dep_name_th":"ห้องแลป","dep_name_en":"LAB","dep_lat":null,"dep_long":null,"wait":2},{"qd_id":"2","id_uni":"2","dep_id":"1","qd_order_number":"1","qd_date":"2017-01-12","qd_time":null,"qd_status":"done","dep_name_th":"ออร์โธปิดิกส์","dep_name_en":"Orthopedics","dep_lat":null,"dep_long":null,"wait":2}]
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
         * qd_id : 15
         * id_uni : 2
         * dep_id : 20
         * qd_order_number : null
         * qd_date : 2017-01-12
         * qd_time : null
         * qd_status : register
         * dep_name_th : ห้องแลป
         * dep_name_en : LAB
         * dep_lat : null
         * dep_long : null
         * wait : 2
         */

        private String qd_id;
        private String id_uni;
        private String dep_id;
        private String qd_order_number;
        private String qd_date;
        private String qd_time;
        private String qd_status;
        private String dep_name_th;
        private String dep_name_en;
        private String dep_lat;
        private String dep_long;
        private String wait;

        public String getQd_id() {
            return qd_id;
        }

        public void setQd_id(String qd_id) {
            this.qd_id = qd_id;
        }

        public String getId_uni() {
            return id_uni;
        }

        public void setId_uni(String id_uni) {
            this.id_uni = id_uni;
        }

        public String getDep_id() {
            return dep_id;
        }

        public void setDep_id(String dep_id) {
            this.dep_id = dep_id;
        }

        public Object getQd_order_number() {
            return qd_order_number;
        }

        public void setQd_order_number(String qd_order_number) {
            this.qd_order_number = qd_order_number;
        }

        public String getQd_date() {
            return qd_date;
        }

        public void setQd_date(String qd_date) {
            this.qd_date = qd_date;
        }

        public Object getQd_time() {
            return qd_time;
        }

        public void setQd_time(String qd_time) {
            this.qd_time = qd_time;
        }

        public String getQd_status() {
            return qd_status;
        }

        public void setQd_status(String qd_status) {
            this.qd_status = qd_status;
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

        public String getWait() {
            return wait;
        }

        public void setWait(String wait) {
            this.wait = wait;
        }
    }
}
