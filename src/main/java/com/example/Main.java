package com.example;

import com.example.stringbuilder.CastomStringBuilder;

public class Main {
    public static void main(String[] args) {
        CastomStringBuilder sb = new CastomStringBuilder();

        System.out.println("Собираем строку:");
        sb.append("Hello");
        System.out.println(sb);

        sb.append(", world");
        System.out.println(sb);

        sb.append("!");
        System.out.println(sb);

        System.out.println("Повторяем undo x3:");
        sb.undo();
        System.out.println(sb);
        sb.undo();
        System.out.println(sb);
        sb.undo();
        System.out.println(sb);

        System.out.println("Результат вызова canUndo: " + sb.canUndo());
        System.out.println("Вызов undo на пустой истории: " + sb.undo());

        System.out.println("Проверка различных операций:");
        CastomStringBuilder m = new CastomStringBuilder();
        m.append("abc");
        m.insert(1, "X");
        m.delete(0, 1);
        m.reverse();
        System.out.println(m);
        m.undo(); System.out.println(m);
        m.undo(); System.out.println(m);
        m.undo(); System.out.println(m);
        m.undo(); System.out.println(m);

        System.out.println("Проверка на конечной строке:");
        CastomStringBuilder b = new CastomStringBuilder(2);
        b.append("1").append("2").append("3");
        System.out.println(b);
        b.undo(); System.out.println(b);
        b.undo(); System.out.println(b);
        System.out.println("Можно ли выполнить undo ещё раз: " + b.undo());
    }
}
