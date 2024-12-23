package com.auggie.student_server.service;

import com.auggie.student_server.entity.Course;
import com.auggie.student_server.entity.CourseTeacher;
import com.auggie.student_server.entity.CourseTeacherInfo;
import com.auggie.student_server.mapper.CourseTeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service
public class CourseTeacherService {
    @Autowired
    private CourseTeacherMapper courseTeacherMapper;

    public boolean insertCourseTeacher(Integer cid, Integer tid, String term) {
        return courseTeacherMapper.insertCourseTeacher(cid, tid, term);
    }

    public List<Course> findMyCourse(Integer tid, String term) {
        return courseTeacherMapper.findMyCourse(tid, term);
    }

    public List<CourseTeacherInfo> findCourseTeacherInfo(Map<String, String> map) {
        Integer tid = null, cid = null;
        Integer tFuzzy = null, cFuzzy = null;
        String tname = null, cname = null;
        String ctype_name = null;
        if (map.containsKey("tid")) {
            try {
                tid = Integer.parseInt(map.get("tid"));
            }
            catch (Exception e) {
            }
        }
        if (map.containsKey("cid")) {
            try {
                cid = Integer.parseInt(map.get("cid"));
            }
            catch (Exception e) {
            }
        }
        if (map.containsKey("tname")) {
            tname = map.get("tname");
        }
        if (map.containsKey("cname")) {
            cname = map.get("cname");
        }
        if (map.containsKey("tFuzzy")) {
            tFuzzy = (map.get("tFuzzy").equals("true")) ? 1 : 0;
        }
        if (map.containsKey("cFuzzy")) {
            cFuzzy = (map.get("cFuzzy").equals("true")) ? 1 : 0;
        }
        if (map.containsKey("ctype_name")) {
            try{
                ctype_name = map.get("ctype_name");
            }catch (Exception e){

            }

        }

        return courseTeacherMapper.findCourseTeacherInfo(tid, tname, tFuzzy, cid, cname, cFuzzy,ctype_name);
    }

    public List<CourseTeacher> findBySearch(Integer cid, Integer tid, String term) {
        return courseTeacherMapper.findBySearch(cid, tid, term);
    }

    public List<CourseTeacher> findBySearch(Map<String, String> map) {
        Integer cid = null;
        Integer tid = null;
        String  term = null;

        if (map.containsKey("term")) {
            term = map.get("term");
        }

        if (map.containsKey("tid")) {
            try {
                tid = Integer.parseInt(map.get("tid"));
            }
            catch (Exception e) {
            }
        }

        if (map.containsKey("cid")) {
            try {
                cid = Integer.parseInt(map.get("cid"));
            }
            catch (Exception e) {
            }
        }
        System.out.println("开课表查询：" + map);
        return courseTeacherMapper.findBySearch(cid, tid, term);
    }

    public boolean deleteById(CourseTeacher courseTeacher) {
        return courseTeacherMapper.deleteById(courseTeacher);
    }

    public boolean delete(int cid) {
        return courseTeacherMapper.delete(cid);
    }
}
