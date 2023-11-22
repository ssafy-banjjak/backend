package com.ssafy.banjjak.shorts.service;

import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.ssafy.banjjak.shorts.model.SearchCond;
import com.ssafy.banjjak.shorts.model.ShortDto;
import com.ssafy.banjjak.shorts.model.ShortFile;
import com.ssafy.banjjak.shorts.model.mapper.ShortMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class ShortServiceImpl implements ShortService {

    private final ShortMapper shortMapper;
    private final Storage storage;

    @Override
    public List<ShortDto> findBySearchCond(SearchCond searchCond) {
        int currentPage = searchCond.getPageNo();
        int sizePerPage = searchCond.getAmount();
        searchCond.setPageNo(currentPage * sizePerPage - sizePerPage);
        return shortMapper.findAllWithSearchCond(searchCond);
    }

    @Override
    public ShortDto findByShortId(Long shortId) {
        return shortMapper.findById(shortId);
    }

    @Override
    public void createShort(ShortFile shortFile) throws IOException {
        String thumbnail = uploadFileToGCS(shortFile.getImage());
        String filePath = uploadFileToGCS(shortFile.getVideo());
        ShortDto shortDto = ShortDto.builder()
            .userId(shortFile.getUserId())
            .region(shortFile.getRegion())
            .title(shortFile.getTitle())
            .content(shortFile.getContent())
            .thumbnail("https://storage.googleapis.com/banjjak/" + thumbnail)
            .filePath("https://storage.googleapis.com/banjjak/" + filePath)
            .build();
        shortMapper.save(shortDto);
    }

    @Override
    public void updateLike(Long shortId) {
        shortMapper.updateLike(shortId);
    }

    @Override
    public void updateDislike(Long shortId) {
        shortMapper.updateDislike(shortId);
    }

    public String uploadFileToGCS(MultipartFile multipartFile) throws IOException {
        String uuid = UUID.randomUUID().toString(); // Google Cloud Storage에 저장될 파일 이름
        String ext = multipartFile.getContentType();

        BlobInfo blobInfo = storage.create(
            BlobInfo.newBuilder("banjjak", uuid)
                .setContentType(ext)
                .build(),
            multipartFile.getBytes()
        );

        return uuid;
    }
}
