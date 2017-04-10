package comapp.example.gyq.mvp.main.m.bean;

import java.util.List;

public class Joke {

    /**
     * status : 0
     * msg : ok
     * result : {"pagesize":"3","list":[{"content":"\u201c事到如今，我也不想再隐瞒你了，其实，我并不是你爸爸。\u201d\u201c你是不是缺心眼啊，妈。\u201d","addtime":"2016-12-16 14:52:07","url":"http://m.kaixinhui.com/detail-38394.html"},{"content":"在你绝望的时候，在你认为自己很丑很穷的时候，至少你的想法是对的。。。","addtime":"2016-12-16 14:52:07","url":"http://m.kaixinhui.com/detail-38395.html"},{"content":"有一天，一个老公买安全套给老婆，进店门口，迅速拿起安全套马上结账。他长叹一口气，说道：\u201c还好没人发现。\u201d接着把安全套放进黑色塑料袋。忽然间，他的朋友抢过塑料袋说：\u201c我帮你丢！\u201d","addtime":"2016-12-16 14:52:07","url":"http://m.kaixinhui.com/detail-38396.html"}]}
     */

    private String status;
    private String msg;
    private ResultBean result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * pagesize : 3
         * list : [{"content":"\u201c事到如今，我也不想再隐瞒你了，其实，我并不是你爸爸。\u201d\u201c你是不是缺心眼啊，妈。\u201d","addtime":"2016-12-16 14:52:07","url":"http://m.kaixinhui.com/detail-38394.html"},{"content":"在你绝望的时候，在你认为自己很丑很穷的时候，至少你的想法是对的。。。","addtime":"2016-12-16 14:52:07","url":"http://m.kaixinhui.com/detail-38395.html"},{"content":"有一天，一个老公买安全套给老婆，进店门口，迅速拿起安全套马上结账。他长叹一口气，说道：\u201c还好没人发现。\u201d接着把安全套放进黑色塑料袋。忽然间，他的朋友抢过塑料袋说：\u201c我帮你丢！\u201d","addtime":"2016-12-16 14:52:07","url":"http://m.kaixinhui.com/detail-38396.html"}]
         */

        private String pagesize;
        private List<ListBean> list;

        public String getPagesize() {
            return pagesize;
        }

        public void setPagesize(String pagesize) {
            this.pagesize = pagesize;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * content : “事到如今，我也不想再隐瞒你了，其实，我并不是你爸爸。”“你是不是缺心眼啊，妈。”
             * addtime : 2016-12-16 14:52:07
             * url : http://m.kaixinhui.com/detail-38394.html
             */

            private String content;
            private String addtime;
            private String url;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getAddtime() {
                return addtime;
            }

            public void setAddtime(String addtime) {
                this.addtime = addtime;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            @Override
            public String toString() {
                return "ListBean{" +
                        "content='" + content + '\'' +
                        ", addtime='" + addtime + '\'' +
                        ", url='" + url + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "ResultBean{" +
                    "pagesize='" + pagesize + '\'' +
                    ", list=" + list +
                    '}';
        }
    }


    @Override
    public String toString() {
        return "Joke{" +
                "status='" + status + '\'' +
                ", msg='" + msg + '\'' +
                ", result=" + result +
                '}';
    }
}
