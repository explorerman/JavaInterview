package Lambda;

import javax.crypto.spec.PSource;
import javax.swing.*;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamListToMap {

    public void mapToList() {
        Map<Long, List<String>> map = new HashMap<>();
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        List<String> list2 = new ArrayList<>();
        list2.add("3");
        list2.add("4");
        List<String> list3 = new ArrayList<>();
        list3.add("5");
        list3.add("6");
        map.put(1L, list1);
        map.put(3L, list2);
        map.put(5L, list3);
        System.out.println(map);
        final List<List<String>> collect = map.values().stream().collect(Collectors.toList());
        System.out.println(collect);
        final List<String> collect1 = collect.stream().flatMap(list -> list.stream()).collect(Collectors.toList());
        System.out.println(collect1);

        Stream<String> stream = Stream.of("I", "love", "you", "too", "you");
        final Map<String, Integer> collect2 = stream
                .collect(Collectors.toMap(Function.identity(), String::length, (k1, k2) -> k2));
        System.out.println(collect2);
    }

    public void listToMap(){
        List<Image> list = new ArrayList<>();
        list.add(new Image(1l, "1"));
        list.add(new Image(2l, "2"));
        list.add(new Image(3l, "3"));
        list.add(new Image(4l, "4"));
        Map<Long, List<Image>> collect = list.stream().collect(Collectors.groupingBy(Image::getItemid));
        System.out.println(collect);
    }

    public static void main(String[] args) {
        Map<Long, List<Image>> source = new HashMap<>();
        List<Image> list1l = new ArrayList<>();
        list1l.add( new Image(1l, "1", "value1"));
        source.put(1l,list1l);
        List<Image> list2l = new ArrayList<>();
        list2l.add( new Image(2l, "2", "value2"));
        source.put(2l,list2l);

        List<Image> list = new ArrayList<>();
        list.add(new Image(1l, "1"));
        list.add(new Image(3l, "3"));
        list.add(new Image(4l, "4"));
        list.add(new Image(2l, "2"));
        Map<Long, List<Image>> collect = list.stream().collect(Collectors.groupingBy(Image::getItemid));
        //倒序排
        for (Long key : collect.keySet()){
//            collect.get(key).stream().sorted(new Comparator<Image>() {
//                @Override
//                public int compare(Image o1, Image o2) {
//                    return (int) (o2.getItemid() - o1.getItemid());
//                }
//            });
            collect.get(key).stream().sorted(((o1, o2) -> {
                return (int) (o2.getItemid() - o1.getItemid());
            }));
        }
        collect.keySet().stream().forEach(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) {
                collect.get(aLong).stream().sorted(((o1, o2) -> {
                    return (int) (o2.getItemid() - o1.getItemid());
                }));
            }
        });
        collect.keySet().stream().forEach((aLong -> {
            collect.get(aLong).stream().sorted(((o1, o2) -> {
                return (int) (o2.getItemid() - o1.getItemid());
            }));
        }));
        System.out.println(collect);

        for(Long key : collect.keySet()){
            for (Long key2 : source.keySet()){
                if(collect.get(key) == source.get(key2)){
                    List<Image> imagekey1 = collect.get(key);
                    List<Image> imagekey2 = collect.get(key2);
                    for (Image image1: imagekey1){
                        for (Image image2: imagekey2){
                            if(image1.getValue() == image2.value){
                                image1.setImageUrl(image2.getImageUrl());
                            }
                        }
                    }
                }
            }
        }
        //collect是request的，source是global的
        collect.keySet().stream().forEach((collectKey -> {
            source.keySet().stream().forEach(sourceKey -> {
                if(collect.get(collectKey) == source.get(sourceKey)){
                    collect.get(collectKey).stream().forEach(collectImage -> {
                        source.get(sourceKey).stream().forEach(sourceImage ->{
                            if(collectImage.getValue() == sourceImage.getValue()){
                                collectImage.setImageUrl(sourceImage.getImageUrl());
                            }
                        });
                    });
                }
            });
        }));
    }

    public static class Image {
        long itemid;
        String imageUrl;
        String value;

        public Image(long itemid, String imageUrl) {
            this.itemid = itemid;
            this.imageUrl = imageUrl;
        }

        public Image(long itemid, String imageUrl, String value) {
            this.itemid = itemid;
            this.imageUrl = imageUrl;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public long getItemid() {
            return itemid;
        }

        public void setItemid(long itemid) {
            this.itemid = itemid;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }
    }
}
