package pres.zhs.rlbackend.infra.readfile;

import pres.zhs.rlbackend.api.dto.ChannelDataObj;

import java.io.*;
import java.util.*;

public class ReadMatFile {
    public static List<ChannelDataObj> readMatFile() {

        List<List<Double>> channelData = readChannelData("D:\\a_paper\\rlBackend\\src\\main\\resources\\templates\\channel_data.txt");
        List<Double> rateData = readRateData("D:\\a_paper\\rlBackend\\src\\main\\resources\\templates\\rate_data.txt");

        Random random = new Random();
        int x = random.nextInt(28000);

        List<ChannelDataObj> data = new ArrayList<>(10);
        for (int i = x; i < x + 10; i++) {
            ChannelDataObj build = ChannelDataObj.builder()
                    .channel(channelData.get(i).toString())
                    .actuallyVMax(rateData.get(i).toString())
                    .build();
            data.add(build);
        }

        return data;
    }

    public static List<List<Double>> readChannelData(String fileName) {
        List<List<Double>> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                List<Double> row = new ArrayList<>();
                String[] values = line.trim().split("\\s+");
                for (String value : values) {
                    row.add(Double.parseDouble(value));
                }
                data.add(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static List<Double> readRateData(String fileName) {
        List<Double> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String value = line.trim();
                data.add(Double.parseDouble(value));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
