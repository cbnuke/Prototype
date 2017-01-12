package com.cbnuke.prototype.model;

/**
 * Created by Amnart on 12/1/2560.
 */

public class StatusPatient {

    /**
     * data : {"pat_hn":"12345","pat_pass":"1234","pat_firstname":"Test","pat_lastname":"Test","pat_tel":"10234","pat_age":"28","pat_token":"eYSsKeLS25I:APA91bGJG0y_zRYuqgm5rEz1nHBWwdbdwhN0Mm43MM8HaXdrHUO86s-7mbLWTbqap5EWtp83sflu22-XGUbPh4hMc2N65DFN3oqE1wZbKlKZ8ICKFW7TjIHpDGDamTC7w2FEMaYAHf8y"}
     * status : success
     */

    private DataEntity data;
    private String status;

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class DataEntity {
        /**
         * pat_hn : 12345
         * pat_pass : 1234
         * pat_firstname : Test
         * pat_lastname : Test
         * pat_tel : 10234
         * pat_age : 28
         * pat_token : eYSsKeLS25I:APA91bGJG0y_zRYuqgm5rEz1nHBWwdbdwhN0Mm43MM8HaXdrHUO86s-7mbLWTbqap5EWtp83sflu22-XGUbPh4hMc2N65DFN3oqE1wZbKlKZ8ICKFW7TjIHpDGDamTC7w2FEMaYAHf8y
         */

        private String pat_hn;
        private String pat_pass;
        private String pat_firstname;
        private String pat_lastname;
        private String pat_tel;
        private String pat_age;
        private String pat_token;

        public String getPat_hn() {
            return pat_hn;
        }

        public void setPat_hn(String pat_hn) {
            this.pat_hn = pat_hn;
        }

        public String getPat_pass() {
            return pat_pass;
        }

        public void setPat_pass(String pat_pass) {
            this.pat_pass = pat_pass;
        }

        public String getPat_firstname() {
            return pat_firstname;
        }

        public void setPat_firstname(String pat_firstname) {
            this.pat_firstname = pat_firstname;
        }

        public String getPat_lastname() {
            return pat_lastname;
        }

        public void setPat_lastname(String pat_lastname) {
            this.pat_lastname = pat_lastname;
        }

        public String getPat_tel() {
            return pat_tel;
        }

        public void setPat_tel(String pat_tel) {
            this.pat_tel = pat_tel;
        }

        public String getPat_age() {
            return pat_age;
        }

        public void setPat_age(String pat_age) {
            this.pat_age = pat_age;
        }

        public String getPat_token() {
            return pat_token;
        }

        public void setPat_token(String pat_token) {
            this.pat_token = pat_token;
        }
    }
}
