package org.example.functions;

import org.example.Entity.CoursePreference;
import org.example.Entity.Lesson;
import org.example.Entity.Student;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class Functions {
    public static BiFunction<Lesson,Lesson,Boolean> lessonCompare = (lesson, lesson1) ->{
        boolean sameDay = Objects.equals(lesson1.getDays(), lesson.getDays());
        boolean inSameTime = lesson.getEndLesson().isAfter(lesson1.getStartLesson()) && lesson.getStartLesson().isBefore(lesson1.getStartLesson()) ||
                lesson.getStartLesson().isBefore(lesson1.getEndLesson()) && lesson.getEndLesson().isAfter(lesson1.getEndLesson()) ;
        if (sameDay && inSameTime) {
            return false;
        }else {
            return true;
        }
    };
}
