package com.max.opTask.views;

public interface GenericView<T, Integer> {
    public void printAll();
    //public void printById(Integer id);
    public T Update();
    public T save();
    public void delete();
}
