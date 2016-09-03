package com.ytadpole.demo1.bean;

import java.util.List;

/**
 * Created by YS on 2016/9/3.
 */
public class HomeBean {

    /**
     * error : false
     * results : [{"_id":"57bff3d5421aa9125fa3ed92","createdAt":"2016-08-26T15:46:29.18Z","desc":"一个关于音乐随机播放的算法","publishedAt":"2016-09-02T20:36:28.951Z","source":"web","type":"Android","url":"http://www.jianshu.com/p/472fed76690a","used":true,"who":null},{"_id":"57bff672421aa9125fa3ed93","createdAt":"2016-08-26T15:57:38.225Z","desc":"Android 自定义漂亮 Dialog。","publishedAt":"2016-09-02T20:36:28.951Z","source":"chrome","type":"Android","url":"https://github.com/pedant/sweet-alert-dialog","used":true,"who":"暖火"},{"_id":"57c799e5421aa9125d96f54c","createdAt":"2016-09-01T11:00:53.521Z","desc":"一波React Native Material Design","publishedAt":"2016-09-02T20:36:28.951Z","source":"chrome","type":"Android","url":"https://github.com/react-native-material-design/react-native-material-design","used":true,"who":"AndWang"},{"_id":"57c7d956421aa91265f4a416","createdAt":"2016-09-01T15:31:34.680Z","desc":"Android 的录音库，可录制 pcm 和 wav，暂停／继续录制","publishedAt":"2016-09-02T20:36:28.951Z","source":"web","type":"Android","url":"https://kailash09dabhi.github.io/OmRecorder/","used":true,"who":"color"},{"_id":"57c80811421aa9125fa3edcf","createdAt":"2016-09-01T18:50:57.908Z","desc":"基于itemtouchhelper，实现左滑菜单，删除确认","publishedAt":"2016-09-02T20:36:28.951Z","source":"web","type":"Android","url":"https://github.com/loopeer/itemtouchhelper-extension","used":true,"who":null},{"_id":"57c832d3421aa9125fa3edd1","createdAt":"2016-09-01T21:53:23.440Z","desc":"RecyclerView Snap 边缘停止效果，让你的 App 更人性化，更精致。","publishedAt":"2016-09-02T20:36:28.951Z","source":"chrome","type":"Android","url":"https://github.com/rubensousa/RecyclerViewSnap","used":true,"who":"代码家"},{"_id":"57c67ca8421aa9125d96f543","createdAt":"2016-08-31T14:43:52.969Z","desc":"【Android干货】Matrix详解，这应该是目前最详细的一篇讲解Matrix的中文文章了。","publishedAt":"2016-09-01T11:31:19.288Z","source":"web","type":"Android","url":"http://www.gcssloop.com/2015/02/Matrix_Method/","used":true,"who":"sloop"},{"_id":"57c67e1e421aa9125fa3edc1","createdAt":"2016-08-31T14:50:06.126Z","desc":"Android热修复实践应用--AndFix","publishedAt":"2016-09-01T11:31:19.288Z","source":"web","type":"Android","url":"http://www.jianshu.com/p/c36c9e0ca3fe","used":true,"who":"郑铉"},{"_id":"57c75d23421aa91265f4a40e","createdAt":"2016-09-01T06:41:39.768Z","desc":"Google 放出的依赖注入框架，Tiger，速度是最大优势。","publishedAt":"2016-09-01T11:31:19.288Z","source":"chrome","type":"Android","url":"https://github.com/google/tiger","used":true,"who":"代码家"},{"_id":"57c75e58421aa9125fa3edc9","createdAt":"2016-09-01T06:46:48.127Z","desc":"利用 KeyStore 存储密码，加密 SharedPreference 的数据，保证安全性。","publishedAt":"2016-09-01T11:31:19.288Z","source":"chrome","type":"Android","url":"https://github.com/iamMehedi/Secured-Preference-Store","used":true,"who":"代码家"}]
     */

    private boolean error;
    /**
     * _id : 57bff3d5421aa9125fa3ed92
     * createdAt : 2016-08-26T15:46:29.18Z
     * desc : 一个关于音乐随机播放的算法
     * publishedAt : 2016-09-02T20:36:28.951Z
     * source : web
     * type : Android
     * url : http://www.jianshu.com/p/472fed76690a
     * used : true
     * who : null
     */

    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private Object who;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public Object getWho() {
            return who;
        }

        public void setWho(Object who) {
            this.who = who;
        }
    }
}
