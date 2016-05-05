package com.android.bushelper.bean;

import java.util.List;

public class TicketBean {

    /**
     * reason : 查询成功
     * result : {"list":[{"start":"长途客运南站","arrive":"上海","date":"06:33","price":"38元"},{"start":"浦东长途东站","arrive":"上海","date":"06:47","price":"38元"},{"start":"长途汽车客运总站","arrive":"上海","date":"06:55","price":"38元"},{"start":"长途客运南站","arrive":"上海","date":"07:07","price":"38元"},{"start":"长途客运南站","arrive":"上海","date":"07:27","price":"38元"},{"start":"长途客运南站","arrive":"上海","date":"07:47","price":"38元"},{"start":"长途汽车客运总站","arrive":"上海","date":"07:50","price":"38元"},{"start":"长途客运南站","arrive":"上海","date":"08:47","price":"38元"},{"start":"长途客运南站","arrive":"上海","date":"09:07","price":"38元"},{"start":"长途客运南站","arrive":"上海","date":"09:27","price":"38元"},{"start":"长途汽车客运总站","arrive":"上海","date":"09:30","price":"38元"},{"start":"长途客运南站","arrive":"上海","date":"09:47","price":"38元"},{"start":"长途客运南站","arrive":"上海","date":"10:07","price":"38元"},{"start":"长途汽车客运总站","arrive":"上海","date":"10:10","price":"38元"},{"start":"长途客运南站","arrive":"上海","date":"10:27","price":"38元"},{"start":"长途客运南站","arrive":"上海","date":"10:47","price":"38元"},{"start":"长途客运南站","arrive":"上海","date":"11:27","price":"38元"},{"start":"长途汽车客运总站","arrive":"上海","date":"11:30","price":"38元"},{"start":"长途客运南站","arrive":"上海","date":"11:47","price":"38元"},{"start":"浦东长途东站","arrive":"上海","date":"12:00","price":"38元"},{"start":"长途汽车客运总站","arrive":"上海","date":"12:00","price":"38元"},{"start":"长途客运南站","arrive":"上海","date":"12:27","price":"38元"},{"start":"长途汽车客运总站","arrive":"上海","date":"12:35","price":"38元"},{"start":"长途客运南站","arrive":"上海","date":"12:47","price":"38元"},{"start":"长途客运南站","arrive":"上海","date":"13:07","price":"38元"},{"start":"长途客运南站","arrive":"上海","date":"13:27","price":"38元"},{"start":"长途客运南站","arrive":"上海","date":"13:47","price":"38元"},{"start":"长途汽车客运总站","arrive":"上海","date":"13:50","price":"38元"},{"start":"长途客运南站","arrive":"上海","date":"14:07","price":"38元"},{"start":"长途客运南站","arrive":"上海","date":"14:27","price":"38元"},{"start":"长途汽车客运总站","arrive":"上海","date":"14:30","price":"38元"},{"start":"长途客运南站","arrive":"上海","date":"14:47","price":"38元"},{"start":"长途客运南站","arrive":"上海","date":"15:07","price":"38元"},{"start":"长途客运南站","arrive":"上海","date":"15:27","price":"38元"},{"start":"长途汽车客运总站","arrive":"上海","date":"16:00","price":"38元"},{"start":"长途客运南站","arrive":"上海","date":"16:07","price":"38元"},{"start":"长途客运南站","arrive":"上海","date":"16:27","price":"38元"},{"start":"长途汽车客运总站","arrive":"上海","date":"16:30","price":"38元"},{"start":"长途客运南站","arrive":"上海","date":"16:47","price":"38元"},{"start":"长途客运南站","arrive":"上海","date":"17:25","price":"38元"},{"start":"长途汽车客运总站","arrive":"上海","date":"17:40","price":"38元"},{"start":"长途客运南站","arrive":"上海","date":"17:47","price":"38元"},{"start":"长途客运南站","arrive":"上海","date":"18:17","price":"38元"},{"start":"长途客运南站","arrive":"上海","date":"18:37","price":"38元"},{"start":"长途汽车客运总站","arrive":"上海","date":"19:25","price":"38元"},{"start":"长途客运南站","arrive":"上海","date":"19:29","price":"38元"}]}
     * error_code : 0
     */

    private String reason;
    private ResultEntity result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultEntity getResult() {
        return result;
    }

    public void setResult(ResultEntity result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultEntity {
        /**
         * start : 长途客运南站
         * arrive : 上海
         * date : 06:33
         * price : 38元
         */

        private List<ListEntity> list;

        public List<ListEntity> getList() {
            return list;
        }

        public void setList(List<ListEntity> list) {
            this.list = list;
        }

        public static class ListEntity {
            private String start;
            private String arrive;
            private String date;
            private String price;

            public String getStart() {
                return start;
            }

            public void setStart(String start) {
                this.start = start;
            }

            public String getArrive() {
                return arrive;
            }

            public void setArrive(String arrive) {
                this.arrive = arrive;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }
        }
    }
}
