package edu.calvin.cs262.hp46;

public class ShoppingNote {

    String text;
    String comment;
    String date;

    public ShoppingNote(String text, String comment, String date)
    {
        this.text = text;
        this.comment = comment;
        this.date = date;
    }

    public String getText()
    {
        return text;
    }

    public String getComment()
    {
        return comment;
    }

    public String getDate()
    {
        return date;
    }

}
