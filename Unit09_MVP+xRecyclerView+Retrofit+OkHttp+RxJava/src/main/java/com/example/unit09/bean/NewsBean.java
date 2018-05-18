package com.example.unit09.bean;

import java.util.List;

/**
 * http://api.tianapi.com/apple/?key=18e883dd6b316eb1d97fd86338abbf06&num=10
 */

public class NewsBean {

    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2017-01-12 00:00","title":"FBI公布：解锁圣贝纳迪诺枪击案苹果iPhone文件","description":"爱思助手","picUrl":"http://d.image.i4.cn/i4web/image/news/2017-01-12/1484183191694.jpg","url":"http://www.i4.cn/news_detail_12575.html"},{"ctime":"2017-01-12 00:00","title":"苹果iPhone8曲面OLED、全面屏设计没跑了","description":"爱思助手","picUrl":"http://d.image.i4.cn/i4web/image/news/2017-01-12/1484183427455.jpg","url":"http://www.i4.cn/news_detail_12576.html"},{"ctime":"2017-01-12 00:00","title":"AirPods很好用，65%用户表示不会掉落","description":"爱思助手","picUrl":"http://d.image.i4.cn/i4web/image/news/2017-01-12/1484183889681.jpg","url":"http://www.i4.cn/news_detail_12578.html"},{"ctime":"2017-01-12 00:00","title":"安卓国内扩张 英美法日iOS份额呈上涨趋势","description":"爱思助手","picUrl":"http://d.image.i4.cn/i4web/image/news/2017-01-12/1484184176533.jpg","url":"http://www.i4.cn/news_detail_12579.html"},{"ctime":"2017-01-12 00:00","title":"2017第一拍：看苹果新园区建设成什么样了","description":"爱思助手","picUrl":"http://d.image.i4.cn/i4web/image/news/2017-01-12/1484184404973.jpg","url":"http://www.i4.cn/news_detail_12580.html"},{"ctime":"2017-01-12 00:00","title":"AirPods这么给力，这是要改变整个耳机市场的节奏","description":"爱思助手","picUrl":"http://d.image.i4.cn/i4web/image/news/2017-01-12/1484184961189.jpg","url":"http://www.i4.cn/news_detail_12582.html"},{"ctime":"2017-01-12 00:00","title":"全球iPhone平均价：中国第三便宜","description":"爱思助手","picUrl":"http://d.image.i4.cn/i4web/image/news/2017-01-12/1484185624847.jpg","url":"http://www.i4.cn/news_detail_12583.html"},{"ctime":"2017-01-11 00:00","title":"为苹果市值增100亿刀？AirPods真是潜力无限","description":"爱思助手","picUrl":"http://d.image.i4.cn/i4web/image/news/2017-01-11/1484114745390.jpg","url":"http://www.i4.cn/news_detail_12562.html"},{"ctime":"2017-01-11 00:00","title":"ESPN应用升级已经支持苹果的单次登录功能","description":"爱思助手","picUrl":"http://d.image.i4.cn/i4web/image/news/2017-01-11/1484114938228.jpg","url":"http://www.i4.cn/news_detail_12563.html"},{"ctime":"2017-01-11 00:00","title":"苹果15款历代产品拆解图   这就是苹果的发展","description":"爱思助手","picUrl":"http://d.image.i4.cn/i4web/image/news/2017-01-11/1484113551722.jpg","url":"http://www.i4.cn/news_detail_12558.html"}]
     */

    private int code;
    private String msg;
    private List<NewslistBean> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NewslistBean> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewslistBean> newslist) {
        this.newslist = newslist;
    }

    public static class NewslistBean {
        /**
         * ctime : 2017-01-12 00:00
         * title : FBI公布：解锁圣贝纳迪诺枪击案苹果iPhone文件
         * description : 爱思助手
         * picUrl : http://d.image.i4.cn/i4web/image/news/2017-01-12/1484183191694.jpg
         * url : http://www.i4.cn/news_detail_12575.html
         */

        private String ctime;
        private String title;
        private String description;
        private String picUrl;
        private String url;

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
