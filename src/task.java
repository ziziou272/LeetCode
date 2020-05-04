import java.util.Date;
import java.util.*;
public class task {
    public static void main(String[] args){

        List<Job> jobs = new ArrayList<>();
        Job job1 = new Job(10, 1, 1, 1);
        Job job2 = new Job(10, 2, 2,2);

        Job job3 = new Job(1, 3,3,3);

        Job job4 = new Job(3, 1,4,1);
        Job job5 = new Job(4, 2,5,2);
        Job job6 = new Job(5, 3,6,4);
        jobs.add(job1);
        jobs.add(job2);
        jobs.add(job3);
        jobs.add(job4);
        jobs.add(job5);
        jobs.add(job6);
        List<Integer> jobA = new ArrayList<>();
        List<Integer> jobB = new ArrayList<>();
        jobA.add(1);
        jobA.add(2);
        jobB.add(2);
        jobB.add(3);
        lawyer Alex = new lawyer("Alex", new ArrayList<>(), jobA, new HashSet<>());
        assignJob as = new assignJob();
        as.assign(jobs, Alex);

        as.assign(jobs, Alex);

        as.assign(jobs, Alex);

        as.assign(jobs, Alex);

        as.assign(jobs, Alex);

        as.assign(jobs, Alex);


    }


}
class lawyer{
    String name;
    List<Job> tasks;
    List<Integer> capbleTo;
    HashSet<Integer> custmoerId;
    lawyer(String name, List<Job> tasks, List<Integer> capbleTo, HashSet<Integer> custmoerId){
        this.name = name;
        this.tasks = tasks;
        this.capbleTo = capbleTo;
        this.custmoerId = custmoerId;
    }
}
class Job{
    int id;
    int time;
    int type;
    int custmoerId;
    public Job(int time, int type, int id, int custmoerId){
        this.time = time;
        this.type = type;
        this.id = id;
        this.custmoerId = custmoerId;
    }
}
//a b    b-a >= 10
// 10 11 33 40 50
/* s
*     f
*
* */
class assignJob{
    public void assign(List<Job> jobs, lawyer la){
        Collections.sort(jobs, (a,b) -> a.time- (b.time));
        for(int i = 0; i < jobs.size();i++){
            //capble
            Job cur = jobs.get(i);
            if(la.capbleTo.contains(cur.type)) {
                int curTime = cur.time;
                //check 熟客
                for(int j = i + 1; j<jobs.size();j++){
                    if(la.custmoerId.contains(jobs.get(j).custmoerId) && jobs.get(j).time - 10 <= curTime && la.capbleTo.contains(jobs.get(j).type)){
                        la.custmoerId.add(jobs.get(j).custmoerId);
                        la.tasks.add(jobs.get(j));
                        System.out.println(jobs.get(j).id);
                        jobs.remove(jobs.get(j));
                        return;
                    }
                }
                la.tasks.add(cur);
                la.custmoerId.add(cur.custmoerId);
                System.out.println(cur.id);
                jobs.remove(cur);
                return;
            }
        }
    }
}
class Solutionaaa{
public double[] dse(double[] input){
        //corner case
        if(input == null || input.length == 0)
            return new double[0];
        HashSet<Double> set = new HashSet<>();
        ArrayList<Double> res = new ArrayList();
        for(int i = 0; i < input.length; i++){
            double cur = input[i];
        if(!set.contains(cur))
            res.add(cur);
            set.add(cur);
        }
        double[] arr = new double[res.size()];
        for(int i = 0; i < res.size(); i++){
            arr[i] = res.get(i);
        }
        return arr;
        }
}
