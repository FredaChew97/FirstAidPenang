package my.com.fredachew.firstaidpenang;

public class Question {

    private int TextResId;
    private boolean AnswerTrue;

    public Question(int textResId, boolean answerTrue){
        TextResId=textResId;
        AnswerTrue=answerTrue;
    }

    public boolean isAnswerTrue() {
        return AnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        AnswerTrue = answerTrue;
    }

    public int getTextResId() {
        return TextResId;
    }

    public void setTextResId(int textResId) {
        TextResId = textResId;
    }
}
