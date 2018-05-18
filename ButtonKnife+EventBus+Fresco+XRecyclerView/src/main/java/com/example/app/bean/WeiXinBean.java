package com.example.app.bean;

import java.util.List;

/**
 *  http://api.tianapi.com/wxnew/?key=18e883dd6b316eb1d97fd86338abbf06&num=10
 */
public class WeiXinBean {

    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2018-05-06","title":"别被坑了！车漆小划痕发黄其实你自己都能解决","description":"玩车教授","picUrl":"https://zxpic.gtimg.com/infonew/0/wechat_pics_-62933537.jpg/640","url":"https://mp.weixin.qq.com/s?__biz=MjM5MjEzNzYzOA==&idx=1&mid=2653127955&sn=c1cbd8f71399669a927316d0206687ec"},{"ctime":"2018-05-06","title":"王家卫的电影，如果拿掉音乐会是什么样子？","description":"淘漉音乐","picUrl":"https://zxpic.gtimg.com/infonew/0/wechat_pics_-62933253.jpg/640","url":"https://mp.weixin.qq.com/s?__biz=MzAxMzI4MTUxMw==&idx=3&mid=2653833468&sn=f964f87c0d526b8441bddc76ac9c3db4"},{"ctime":"2018-05-06","title":"惠若琪再受重用！大婚之后就敬业蜜月都不过，新工作太让人敬佩!","description":"懂小姐miss","picUrl":"https://zxpic.gtimg.com/infonew/0/wechat_pics_-62933361.jpg/640","url":"https://mp.weixin.qq.com/s?__biz=MjM5OTYxOTQyMA==&idx=8&mid=2649506762&sn=ed4dd3b4178108c77f7392a721a7a8d5"},{"ctime":"2018-05-06","title":"一曲流连 | 张宇：这场戏的结局，一言难尽","description":"淘漉音乐","picUrl":"https://zxpic.gtimg.com/infonew/0/wechat_pics_-62933253.jpg/640","url":"https://mp.weixin.qq.com/s?__biz=MzAxMzI4MTUxMw==&idx=5&mid=2653833468&sn=35c374c8747b252f62f65969c7861f61"},{"ctime":"2018-05-06","title":"30岁左右，手头有10几20万，这4台合资B级车是首选！","description":"有车以后","picUrl":"https://zxpic.gtimg.com/infonew/0/wechat_pics_-62933322.static/640","url":"https://mp.weixin.qq.com/s?__biz=MzAxMTA0ODE3Mw==&idx=4&mid=2656912556&sn=624ad29164670508e0bd96d542826127"},{"ctime":"2018-05-06","title":"\u201c25岁时，我的月薪是1000个馒头\u201d","description":"MBA智库","picUrl":"https://zxpic.gtimg.com/infonew/0/wechat_pics_-62933201.jpg/640","url":"https://mp.weixin.qq.com/s?__biz=MjM5NDE3NTcwMA==&idx=1&mid=2652665618&sn=c8b4d8ebcc1bd0b2bcaa5f453c02b86b"},{"ctime":"2018-05-06","title":"这些中国力量纷纷崛起，厉害了我的国！","description":"汽车之家","picUrl":"https://zxpic.gtimg.com/infonew/0/wechat_pics_-62933205.static/640","url":"https://mp.weixin.qq.com/s?__biz=MjM5MzA0NDM0MA==&idx=1&mid=2660686008&sn=26b56b0f1dfe9e5b2a735539ccf2d8e8"},{"ctime":"2018-05-06","title":"只有加工资才能救中国经济！（深度好文）","description":"郎club","picUrl":"https://t1.qpic.cn/mblogpic/34d9dfb75cfceb04a840/2000","url":"https://mp.weixin.qq.com/s?__biz=MzA5MDA1NDMzNQ==&idx=3&mid=2651557199&sn=1b607861ef9cab74ec21f12a5d4186cf"},{"ctime":"2018-05-04","title":"海南楼市，一夜冰火：销售称遭灭顶之灾，地产商陷入群体性迷茫！","description":"金融行业网","picUrl":"https://zxpic.gtimg.com/infonew/0/wechat_pics_-62932267.jpg/640","url":"https://mp.weixin.qq.com/s?__biz=MjM5NjAyNjI2MA==&idx=1&mid=2657225126&sn=058a1c34d836fd5af4243bbfd1c8a58e"},{"ctime":"2018-05-04","title":"夏天高温，车自燃都是这四个原因所致！","description":"车早茶","picUrl":"https://zxpic.gtimg.com/infonew/0/wechat_pics_-62932204.jpg/640","url":"https://mp.weixin.qq.com/s?__biz=MzA4MTQxMjQyNA==&idx=6&mid=2650974269&sn=f1c6e0f535e568121057c2bf923aa6c9"}]
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
         * ctime : 2018-05-06
         * title : 别被坑了！车漆小划痕发黄其实你自己都能解决
         * description : 玩车教授
         * picUrl : https://zxpic.gtimg.com/infonew/0/wechat_pics_-62933537.jpg/640
         * url : https://mp.weixin.qq.com/s?__biz=MjM5MjEzNzYzOA==&idx=1&mid=2653127955&sn=c1cbd8f71399669a927316d0206687ec
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
