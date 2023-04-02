package com.example.filtering.filterController;

import com.example.filtering.entity.Address;
import com.example.filtering.entity.Student;
import com.example.filtering.entity.Subject;
import com.example.filtering.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/filter")
public class MyController {
    @Autowired
    private StudentRepo repo;


//       @PostMapping("/addData")
//       @ResponseStatus(HttpStatus.BAD_GATEWAY)
//       public void addData(){
//               Address ads = new Address();
//
//               ads.setCity("Jharkhand");
//
//                Student s = new Student();
//
//                s.setName("Risabh");
//                s.setAddress(ads);
//                ads.setStudent(s);
//                Subject sub = new Subject();
//
//                sub.setName("Physics");
//                sub.setStudentId(s);
//
//           Subject sub2 = new Subject();
//
//           sub2.setName("History");
//           sub2.setStudentId(s);
//
//
//           Subject sub3 = new Subject();
//
//           sub3.setName("Biology");
//           sub3.setStudentId(s);
//
//           HashSet<Subject> sbjs = new HashSet<>();
//           sbjs.add(sub);
//           sbjs.add(sub2);
//           sbjs.add(sub3);
//           s.setSubjects(sbjs);
//
//
//           Student save = repo.save(s);
//
//
//       }
       @GetMapping("/{name}")
      public Student getStdByName(@PathVariable(name="name") String name){
                  return  repo.findByName(name);
       }
       @GetMapping("/city/{city}")
       public List<Student> getStdByAddCity(@PathVariable(name="city")String city){
           return repo.findByAddressCity(city);
       }

    @GetMapping("/subject/{subjectName}")
    public List<Student> getStdBySubjectsName(@PathVariable(name="subjectName")String subjectName){
        return repo.findBySubjectsName(subjectName);
    }
}
