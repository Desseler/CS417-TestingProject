public class Exam implements Cloneable
{

    private Teacher teacher;

    private Student student;

    private String name;

    private String[] questions;

    private String[] answers;

    private Double grade = null;

    private boolean ready=false,done=false;

    public Exam(String name, int numQuestions)
    {
        this.questions = new String[numQuestions];
        this.answers = new String[numQuestions];
        this.name = name;
    }

    public Exam(String name, String[] questions)
    {
        this.questions = questions;
        if(this.questions == null)
            this.answers = null;
        else
            this.answers = new String[questions.length];
        this.name = name;
    }

    public boolean getReady()
    {
        return this.ready;
    }

    public void setReady()
    {
        this.ready = true;
    }

    public boolean getDone()
    {
        return this.done;
    }

    public boolean setDone()
    {
        if(this.ready && this.name != null)
        {
            this.done = true;
            this.teacher.readyForGrading(this);
            return true;
        }
        return false;
    }

    public String getQuestion(int index)
    {
        if(index > -1 && this.questions != null && index < this.questions.length)
        {
            return this.questions[index];
        }
        return null;
    }

    public boolean setQuestion(String question, int index)
    {
        if(!this.ready && this.questions != null && index > -1 && index < this.questions.length)
        {
            this.questions[index]  = question;
            return true;
        }
        return false;
    }

    public boolean setQuestions(String[] questions)
    {
        if(!this.ready)
        {
            for(int i = 0; i < questions.length && i < this.questions.length; i++)
            {
                this.questions[i] = questions[i];
            }
            return true;
        }
        return false;
    }

    public String getAnswer(int index)
    {
        if(index > -1 && this.answers != null && index < this.answers.length)
        {
            return this.answers[index];
        }
        return null;
    }

    public boolean setAnswer(String answer, int index)
    {
        if(this.ready && !this.done && index > -1 && this.answers != null && index < this.answers.length)
        {
            this.answers[index] = answer;
            return true;
        }
        return false;
    }

    public boolean setAnswers(String[] answers)
    {
        if(this.ready && !this.done)
        {
            for(int i = 0; i < answers.length && i < this.answers.length; i++)
            {
                this.answers[i] = answers[i];
            }
            return true;
        }
        return false;
    }

    public int getLength()
    {
        return this.questions.length;
    }

    public void setTeacher(Teacher t)
    {
        this.teacher = t;
    }

    public void sign(Student student)
    {
        this.student = student;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setGrade(double d)
    {
        this.grade = d;
    }

    public double getGrade()
    {
        return this.grade;
    }

    public Exam clone()
    {
        if(this.ready && !this.done)
            return new Exam(this.name, this.questions);
        return null;
    }
}
