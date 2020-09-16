package EnumLearning;

public enum NewsRSSFeedEnum {
    YAHOO_TOP_STOIES("http://rss.news.yahoo.com/rss/topstories"),//not ";"
    CBS_TOP_STOIES("http://xxxxx"),
    LATIMES_TOP_STOIES("http://xxsssxxx");

    private String rssUrl;

    private NewsRSSFeedEnum(String rss) {
        this.rssUrl = rss;
    }

    public String getRssUrl() {
        return this.rssUrl;
    }

    public String fetch() {
        //fetch from this.rssUrl
        return this.rssUrl;
    }
}
