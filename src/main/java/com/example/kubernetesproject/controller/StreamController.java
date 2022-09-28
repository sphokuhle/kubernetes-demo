package com.example.kubernetesproject.controller;

import com.example.kubernetesproject.dto.StreamDto;
import com.example.kubernetesproject.entity.Stream;
import com.example.kubernetesproject.repository.StreamRepository;
import com.example.kubernetesproject.service.KeycloakKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/stream/")
public class StreamController {

    @Autowired
    StreamRepository streamRepository;

    @Autowired
    KeycloakKeyService keycloakKeyService;

    @GetMapping("all")
    public Iterable<Stream> getStreams(){
        return streamRepository.findAll();
    }

    @GetMapping("testNativeList")
    public List<Object[]> getNativeList() {
        return streamRepository.getResults();
    }

    @GetMapping("findFirst")
    public StreamDto findFirst() {
       Stream stream = streamRepository.findLast();
       return new StreamDto(stream);
    }

    @GetMapping("getCertainColumns")
    public List<Object[]> getCertainColumns() {

        return streamRepository.getNamesAndCodes();
    }

    @GetMapping
    public Map<String, String> getCertificates() {
        return keycloakKeyService.getPublicKeys();
    }

    @GetMapping("testNativeMap")
    public Map<String, BigInteger> getNativeMap() {
        /*List<BigInteger> list = new ArrayList<>();
        Map<String, Object> map = streamRepository.getMappedResults();
        map.forEach((k,v)-> {
            list.add((BigInteger) v);
        });
        System.out.println("List: "+ Arrays.toString(list.toArray()));*/
        return streamRepository.getMappedResults();
    }

}
