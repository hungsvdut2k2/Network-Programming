package Bean;

public class History {
    public History(int userId, int corpusId) {
        this.userId = userId;
        this.corpusId = corpusId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCorpusId() {
        return corpusId;
    }

    public void setCorpusId(int corpusId) {
        this.corpusId = corpusId;
    }

    private int userId;
    private int corpusId;
}
