package pl.snz.pubweb.pub.module.pub.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.snz.pubweb.commons.util.Mappers;
import pl.snz.pubweb.pub.module.common.PresentationUris;
import pl.snz.pubweb.pub.module.picture.model.Picture;
import pl.snz.pubweb.pub.module.picture.dto.PictureDto;
import pl.snz.pubweb.pub.module.common.mapper.AddressMapper;
import pl.snz.pubweb.pub.module.pub.dto.PubBriefDto;
import pl.snz.pubweb.pub.module.pub.dto.PubDto;
import pl.snz.pubweb.pub.module.pub.model.Pub;
import pl.snz.pubweb.pub.module.tag.TagMapper;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PubMapper {

    private final PresentationUris presentationUris;
    private final AddressMapper addressMapper;
    private final TagMapper tagMapper;

    public PubDto toGetResponse(Pub pub) {
        return PubDto.builder()
                .id(pub.getId())
                .name(pub.getName())
                .address(addressMapper.toDto(pub.getAddress()))
                .description(pub.getDescription())
                .tags(Mappers.list(pub.getTags(), tagMapper::toDto))
                .pictures(Mappers.list(pub.getPictures(), this::map))
                .added(pub.getAdded())
                .build();
    }

    public PubBriefDto toBrief(Pub pub) {
        return PubBriefDto.builder()
                .id(pub.getId())
                .name(pub.getName())
                .address(addressMapper.toDto(pub.getAddress()))
                .build();
    }

    private PictureDto map(Picture picture) {
        return PictureDto
                .builder()
                .id(picture.getId())
                .name(picture.getName())
                .build();
    }

}
