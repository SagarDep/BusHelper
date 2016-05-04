package com.android.bushelper.bean;

import java.util.List;

public class LineBean {

    /**
     * reason : success
     * result : [{"interval8":"","time_interval6":"","terminal_name":"车坊首末站公交站","front_spell":"","line_id":"3205000590","key_name":"１５６路","time_desc":"","front_name":"官渎里立交换乘枢纽站公交站","time_interval4":"","stationdes":[{"code":"320500","stationNum":"1","name":"官渎里立交换乘枢纽站公交站","xy":"120.642464,31.333539"},{"code":"320500","stationNum":"34","name":"淞泽家园六区公交站","xy":"120.734804,31.244439"},{"code":"320500","stationNum":"35","name":"淞泽家园七区公交站","xy":"120.732991,31.243314"},{"code":"320500","stationNum":"36","name":"车坊首末站公交站","xy":"120.729180,31.241852"}],"description":"","interval3":"","interval6":"","time_interval8":"","start_time":"0600","interval4":"","photo_id":"","interval7":"","photo_folder":"","interval5":"","gpsfile_id":"","data_source":"","time_interval3":"","total_price":"1.000000","company":"苏州市工业园区公共交通有限公司","interval1":"","interval2":"","time_interval7":"","speed":"","length":"21.487000","loop":"0","auto":"","time_interval1":"","ic_card":"","double_deck":"","express_way":"","status":"1","time_interval2":"","service_period":"","time_interval5":"","basic_price":"0.000000","end_time":"2100","air":"","terminal_spell":"","type":"list","paper_table_id":"","name":"１５６路（官渎里立交换乘枢纽站－车坊首末站）","commutation_ticket":"0"}]
     * error_code : 0
     */

    private String reason;
    private int error_code;
    /**
     * interval8 :
     * time_interval6 :
     * terminal_name : 车坊首末站公交站
     * front_spell :
     * line_id : 3205000590
     * key_name : １５６路
     * time_desc :
     * front_name : 官渎里立交换乘枢纽站公交站
     * time_interval4 :
     * stationdes : [{"code":"320500","stationNum":"1","name":"官渎里立交换乘枢纽站公交站","xy":"120.642464,31.333539"},{"code":"320500","stationNum":"34","name":"淞泽家园六区公交站","xy":"120.734804,31.244439"},{"code":"320500","stationNum":"35","name":"淞泽家园七区公交站","xy":"120.732991,31.243314"},{"code":"320500","stationNum":"36","name":"车坊首末站公交站","xy":"120.729180,31.241852"}]
     * description :
     * interval3 :
     * interval6 :
     * time_interval8 :
     * start_time : 0600
     * interval4 :
     * photo_id :
     * interval7 :
     * photo_folder :
     * interval5 :
     * gpsfile_id :
     * data_source :
     * time_interval3 :
     * total_price : 1.000000
     * company : 苏州市工业园区公共交通有限公司
     * interval1 :
     * interval2 :
     * time_interval7 :
     * speed :
     * length : 21.487000
     * loop : 0
     * auto :
     * time_interval1 :
     * ic_card :
     * double_deck :
     * express_way :
     * status : 1
     * time_interval2 :
     * service_period :
     * time_interval5 :
     * basic_price : 0.000000
     * end_time : 2100
     * air :
     * terminal_spell :
     * type : list
     * paper_table_id :
     * name : １５６路（官渎里立交换乘枢纽站－车坊首末站）
     * commutation_ticket : 0
     */

    private List<ResultEntity> result;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public List<ResultEntity> getResult() {
        return result;
    }

    public void setResult(List<ResultEntity> result) {
        this.result = result;
    }

    public static class ResultEntity {
        private String interval8;
        private String time_interval6;
        private String terminal_name;
        private String front_spell;
        private String line_id;
        private String key_name;
        private String time_desc;
        private String front_name;
        private String time_interval4;
        private String description;
        private String interval3;
        private String interval6;
        private String time_interval8;
        private String start_time;
        private String interval4;
        private String photo_id;
        private String interval7;
        private String photo_folder;
        private String interval5;
        private String gpsfile_id;
        private String data_source;
        private String time_interval3;
        private String total_price;
        private String company;
        private String interval1;
        private String interval2;
        private String time_interval7;
        private String speed;
        private String length;
        private String loop;
        private String auto;
        private String time_interval1;
        private String ic_card;
        private String double_deck;
        private String express_way;
        private String status;
        private String time_interval2;
        private String service_period;
        private String time_interval5;
        private String basic_price;
        private String end_time;
        private String air;
        private String terminal_spell;
        private String type;
        private String paper_table_id;
        private String name;
        private String commutation_ticket;
        /**
         * code : 320500
         * stationNum : 1
         * name : 官渎里立交换乘枢纽站公交站
         * xy : 120.642464,31.333539
         */

        private List<StationdesEntity> stationdes;

        public String getInterval8() {
            return interval8;
        }

        public void setInterval8(String interval8) {
            this.interval8 = interval8;
        }

        public String getTime_interval6() {
            return time_interval6;
        }

        public void setTime_interval6(String time_interval6) {
            this.time_interval6 = time_interval6;
        }

        public String getTerminal_name() {
            return terminal_name;
        }

        public void setTerminal_name(String terminal_name) {
            this.terminal_name = terminal_name;
        }

        public String getFront_spell() {
            return front_spell;
        }

        public void setFront_spell(String front_spell) {
            this.front_spell = front_spell;
        }

        public String getLine_id() {
            return line_id;
        }

        public void setLine_id(String line_id) {
            this.line_id = line_id;
        }

        public String getKey_name() {
            return key_name;
        }

        public void setKey_name(String key_name) {
            this.key_name = key_name;
        }

        public String getTime_desc() {
            return time_desc;
        }

        public void setTime_desc(String time_desc) {
            this.time_desc = time_desc;
        }

        public String getFront_name() {
            return front_name;
        }

        public void setFront_name(String front_name) {
            this.front_name = front_name;
        }

        public String getTime_interval4() {
            return time_interval4;
        }

        public void setTime_interval4(String time_interval4) {
            this.time_interval4 = time_interval4;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getInterval3() {
            return interval3;
        }

        public void setInterval3(String interval3) {
            this.interval3 = interval3;
        }

        public String getInterval6() {
            return interval6;
        }

        public void setInterval6(String interval6) {
            this.interval6 = interval6;
        }

        public String getTime_interval8() {
            return time_interval8;
        }

        public void setTime_interval8(String time_interval8) {
            this.time_interval8 = time_interval8;
        }

        public String getStart_time() {
            return start_time;
        }

        public void setStart_time(String start_time) {
            this.start_time = start_time;
        }

        public String getInterval4() {
            return interval4;
        }

        public void setInterval4(String interval4) {
            this.interval4 = interval4;
        }

        public String getPhoto_id() {
            return photo_id;
        }

        public void setPhoto_id(String photo_id) {
            this.photo_id = photo_id;
        }

        public String getInterval7() {
            return interval7;
        }

        public void setInterval7(String interval7) {
            this.interval7 = interval7;
        }

        public String getPhoto_folder() {
            return photo_folder;
        }

        public void setPhoto_folder(String photo_folder) {
            this.photo_folder = photo_folder;
        }

        public String getInterval5() {
            return interval5;
        }

        public void setInterval5(String interval5) {
            this.interval5 = interval5;
        }

        public String getGpsfile_id() {
            return gpsfile_id;
        }

        public void setGpsfile_id(String gpsfile_id) {
            this.gpsfile_id = gpsfile_id;
        }

        public String getData_source() {
            return data_source;
        }

        public void setData_source(String data_source) {
            this.data_source = data_source;
        }

        public String getTime_interval3() {
            return time_interval3;
        }

        public void setTime_interval3(String time_interval3) {
            this.time_interval3 = time_interval3;
        }

        public String getTotal_price() {
            return total_price;
        }

        public void setTotal_price(String total_price) {
            this.total_price = total_price;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getInterval1() {
            return interval1;
        }

        public void setInterval1(String interval1) {
            this.interval1 = interval1;
        }

        public String getInterval2() {
            return interval2;
        }

        public void setInterval2(String interval2) {
            this.interval2 = interval2;
        }

        public String getTime_interval7() {
            return time_interval7;
        }

        public void setTime_interval7(String time_interval7) {
            this.time_interval7 = time_interval7;
        }

        public String getSpeed() {
            return speed;
        }

        public void setSpeed(String speed) {
            this.speed = speed;
        }

        public String getLength() {
            return length;
        }

        public void setLength(String length) {
            this.length = length;
        }

        public String getLoop() {
            return loop;
        }

        public void setLoop(String loop) {
            this.loop = loop;
        }

        public String getAuto() {
            return auto;
        }

        public void setAuto(String auto) {
            this.auto = auto;
        }

        public String getTime_interval1() {
            return time_interval1;
        }

        public void setTime_interval1(String time_interval1) {
            this.time_interval1 = time_interval1;
        }

        public String getIc_card() {
            return ic_card;
        }

        public void setIc_card(String ic_card) {
            this.ic_card = ic_card;
        }

        public String getDouble_deck() {
            return double_deck;
        }

        public void setDouble_deck(String double_deck) {
            this.double_deck = double_deck;
        }

        public String getExpress_way() {
            return express_way;
        }

        public void setExpress_way(String express_way) {
            this.express_way = express_way;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getTime_interval2() {
            return time_interval2;
        }

        public void setTime_interval2(String time_interval2) {
            this.time_interval2 = time_interval2;
        }

        public String getService_period() {
            return service_period;
        }

        public void setService_period(String service_period) {
            this.service_period = service_period;
        }

        public String getTime_interval5() {
            return time_interval5;
        }

        public void setTime_interval5(String time_interval5) {
            this.time_interval5 = time_interval5;
        }

        public String getBasic_price() {
            return basic_price;
        }

        public void setBasic_price(String basic_price) {
            this.basic_price = basic_price;
        }

        public String getEnd_time() {
            return end_time;
        }

        public void setEnd_time(String end_time) {
            this.end_time = end_time;
        }

        public String getAir() {
            return air;
        }

        public void setAir(String air) {
            this.air = air;
        }

        public String getTerminal_spell() {
            return terminal_spell;
        }

        public void setTerminal_spell(String terminal_spell) {
            this.terminal_spell = terminal_spell;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getPaper_table_id() {
            return paper_table_id;
        }

        public void setPaper_table_id(String paper_table_id) {
            this.paper_table_id = paper_table_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCommutation_ticket() {
            return commutation_ticket;
        }

        public void setCommutation_ticket(String commutation_ticket) {
            this.commutation_ticket = commutation_ticket;
        }

        public List<StationdesEntity> getStationdes() {
            return stationdes;
        }

        public void setStationdes(List<StationdesEntity> stationdes) {
            this.stationdes = stationdes;
        }

        public static class StationdesEntity {
            private String code;
            private String stationNum;
            private String name;
            private String xy;

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getStationNum() {
                return stationNum;
            }

            public void setStationNum(String stationNum) {
                this.stationNum = stationNum;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getXy() {
                return xy;
            }

            public void setXy(String xy) {
                this.xy = xy;
            }
        }
    }
}
