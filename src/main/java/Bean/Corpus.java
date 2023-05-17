package Bean;

public class Corpus {
    public Corpus(int corpusId, String content) {
        this.corpusId = corpusId;
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

    private int corpusId;
    private String content;
}
