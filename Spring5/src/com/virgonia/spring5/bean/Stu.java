package com.virgonia.spring5.bean;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Stu {
    private Course[] classes;
    private List<String> list;
    private Map<String,String> maps;
    private Set<String> sets;

    public void setClasses(Course[] classes) {
        this.classes = classes;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "classes=" + Arrays.toString(classes) +
                ", \nlist=" + list +
                ", \nmaps=" + maps +
                ", \nsets=" + sets +
                '}';
    }
}
