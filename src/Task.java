import java.io.Serializable;
import java.util.Objects;

public class Task implements Serializable {

    private String mName;
    private String mDueDate;
    private String mDeadline;
    private int mPriority;

    public Task(String name, String dueDate, String deadline, int priority) {
        mName = name;
        mDueDate = dueDate;
        mDeadline = deadline;
        mPriority = priority;
    }

    public Task(Task otherTask){
        mName = otherTask.mName;
        mDueDate = otherTask.mDeadline;
        mDeadline = otherTask.mDeadline;
        mPriority = otherTask.mPriority;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String Name) {
        mName = mName;
    }

    public String getmDueDate() {
        return mDueDate;
    }

    public void setmDueDate(String mDueDate) {
        this.mDueDate = mDueDate;
    }

    public String getmDeadline() {
        return mDeadline;
    }

    public void setmDeadline(String mDeadline) {
        this.mDeadline = mDeadline;
    }

    public int getmPriority() {
        return mPriority;
    }

    public void setmPriority(int mPriority) {
        this.mPriority = mPriority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return mPriority == task.mPriority && Objects.equals(mName, task.mName)
                && Objects.equals(mDueDate, task.mDueDate)
                && Objects.equals(mDeadline, task.mDeadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mName, mDueDate, mDeadline, mPriority);
    }

    @Override
    public String toString() {
        String priority = "";
        switch (mPriority){
            case 1:
                priority = "High";
                break;
            case 2:
                priority = "Medium";
                break;
            case 3:
                priority = "Low";
        }
        return "Task{" +
                "Name='" + mName + '\'' +
                ", DueDate='" + mDueDate + '\'' +
                ", Deadline='" + mDeadline + '\'' +
                ", Priority=" + priority +
                '}';
    }
}
