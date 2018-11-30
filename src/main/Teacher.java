import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.LinkedList;

public class Teacher
{

    private List<Student> students;

    private HashMap<String, Exam> exams = new HashMap<String, Exam>();

    private Queue<Exam> examsToGrade = new LinkedList<Exam>();

    public Teacher()
    {
        this.students = new ArrayList<Student>();
    }

    public Teacher(List<Student> students)
    {
        this.students = students;
    }

    public void createExam(Exam exam)
    {
        exam.setReady();
        this.exams.put(exam.getName(), exam);
    }

    public void readyForGrading(Exam e)
    {
        this.examsToGrade.add(e);
    }

    public void grade()
    {
        Exam key;
        Exam e;
        double grade;

        while((e=this.examsToGrade.poll()) != null)
        {
            grade = 0;
            key = this.exams.get(e.getName());
            for(int i = 0; i < key.getLength(); i++)
            {
                if(key.getAnswer(i).equals(e.getAnswer(i)))
                {
                    grade++;
                }
            }
            grade = grade/key.getLength();
            e.setGrade(grade);
        }
    }

    public void administerExam(String examName) throws IllegalArgumentException
    {
        Student dent;
        Exam exam = this.exams.get(examName);
        Iterator<Student> it = students.iterator();

        if(exam == null)
        {
            throw new IllegalArgumentException("no such exam");
        }

        while(it.hasNext())
        {
            dent = it.next();
            dent.giveExam(exam.clone());
        }
    }
}
