package com.github.pahanuchek.family_tree.model.writer;

import java.io.*;

public class FileHandler implements Writer {
    @Override
    public boolean writeDoc(Object object) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("person.out"));) {
            objectOutputStream.writeObject(object);
            return true;
        } catch (IOException e) {
            System.out.println(e);
        }
        return false;
    }

        @Override
        public Object readDoc () {
            Object object = new Object();
            try (ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream("person.out"));) {
                object = objectInputStream.readObject();
                return object;
            } catch (IOException e) {
                System.out.println(e);
            } catch (ClassNotFoundException e) {
                System.out.println(e);
            }
            return  object;
        }

    }
