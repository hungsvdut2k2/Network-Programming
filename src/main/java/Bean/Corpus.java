package Bean;

public class Corpus {
    public Corpus() {
    }

    public Corpus(int corpusId, String title, String content) {
        this.corpusId = corpusId;
        this.title = title;
        this.content = content;
    }

    public int getCorpusId() {
        return corpusId;
    }

    public void setCorpusId(int corpusId) {
        this.corpusId = corpusId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}
    private int corpusId;
    private String content;
    private String title;
}
