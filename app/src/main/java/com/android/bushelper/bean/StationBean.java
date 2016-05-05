package com.android.bushelper.bean;

import java.util.List;

public class StationBean {

    /**
     * reason : 查询成功
     * result : {"title":"温州市长途汽车站_时刻表","list":[{"name":"温州市双屿客运中心汽车站","tel":"0577-96035/88280050","adds":"温州市温金路西方向高速路口西出口（双屿菜场对面）"},{"name":"温州市客运中心站","tel":"0577--96035","adds":"温州市牛山北路52号"},{"name":"温州市新城汽车站","tel":"0577-88911927","adds":"温州市新城大道219号"},{"name":"温州市汽车南站","tel":"0577--96035","adds":"温州市梧田南塘大道与疏港公路交叉口东北侧"},{"name":"温州市苍南县长运汽车站（西站）","tel":"0577-64773111","adds":"温州市苍南县建兴西路455号"}]}
     * error_code : 0
     */

    private String reason;
    /**
     * title : 温州市长途汽车站_时刻表
     * list : [{"name":"温州市双屿客运中心汽车站","tel":"0577-96035/88280050","adds":"温州市温金路西方向高速路口西出口（双屿菜场对面）"},{"name":"温州市客运中心站","tel":"0577--96035","adds":"温州市牛山北路52号"},{"name":"温州市新城汽车站","tel":"0577-88911927","adds":"温州市新城大道219号"},{"name":"温州市汽车南站","tel":"0577--96035","adds":"温州市梧田南塘大道与疏港公路交叉口东北侧"},{"name":"温州市苍南县长运汽车站（西站）","tel":"0577-64773111","adds":"温州市苍南县建兴西路455号"}]
     */

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
        private String title;
        /**
         * name : 温州市双屿客运中心汽车站
         * tel : 0577-96035/88280050
         * adds : 温州市温金路西方向高速路口西出口（双屿菜场对面）
         */

        private List<ListEntity> list;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<ListEntity> getList() {
            return list;
        }

        public void setList(List<ListEntity> list) {
            this.list = list;
        }

        public static class ListEntity {
            private String name;
            private String tel;
            private String adds;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getTel() {
                return tel;
            }

            public void setTel(String tel) {
                this.tel = tel;
            }

            public String getAdds() {
                return adds;
            }

            public void setAdds(String adds) {
                this.adds = adds;
            }
        }
    }
}
