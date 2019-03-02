package cn.cumtmaker.maker.controller;

import cn.cumtmaker.maker.VO.GroupCollectionVO;
import cn.cumtmaker.maker.VO.StoreVO;
import cn.cumtmaker.maker.service.GroupCollectionsService;
import cn.cumtmaker.maker.service.StoreCollectionsService;
import cn.cumtmaker.maker.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RequestMapping(value="api/collect",produces = {APPLICATION_JSON_UTF8_VALUE})
@RestController
@Api(value="api/collect",tags="CollectionApi",description="收藏接口")
public class CollectionController {
    @Autowired
    StoreCollectionsService storeCollectionsService;
    @Autowired
    GroupCollectionsService groupCollectionsService;
    @Autowired
    UserService userService;

    /**
     * 收藏Store
     * @param request
     * @param collectStoreId
     * @return
     */
    @ApiOperation("收藏Store")
    @PostMapping("/store")
    public ResponseEntity collectStore(HttpServletRequest request, Integer collectStoreId) {
        Integer userId = userService.getUserByRequest(request).getUserId();
        return ResponseEntity.ok(storeCollectionsService.collectStore(userId, collectStoreId));
    }

    /**
     * 收藏Group
     * @param request
     * @param storeId
     * @param collectGroupId
     * @return
     */
    @ApiOperation("收藏Group")
    @PostMapping("/group")
    public ResponseEntity collectGroup(HttpServletRequest request, Integer storeId, Integer collectGroupId) {
        Integer userId = userService.getUserByRequest(request).getUserId();
        return ResponseEntity.ok(groupCollectionsService.collectGroup(userId, storeId, collectGroupId));
    }

    /**
     * 取消收藏Store
     * @param request
     * @param collectStoreId
     * @return
     */
    @ApiOperation("取消收藏Store")
    @DeleteMapping("/store")
    public ResponseEntity cancelCollectStore(HttpServletRequest request, Integer collectStoreId) {
        Integer userId = userService.getUserByRequest(request).getUserId();
        return ResponseEntity.ok(storeCollectionsService.cancelCollectStore(userId, collectStoreId));
    }

    /**
     * 取消收藏Group
     * @param request
     * @param storeId
     * @param collectGroupId
     * @return
     */
    @ApiOperation("取消收藏Group")
    @DeleteMapping("/group")
    public ResponseEntity cancelCollectGroup(HttpServletRequest request, Integer storeId, Integer collectGroupId) {
        Integer userId = userService.getUserByRequest(request).getUserId();
        return ResponseEntity.ok(groupCollectionsService.cancelCollectGroup(userId, storeId, collectGroupId));
    }

    /**
     * 获得所有收藏Store
     * @param request
     * @return
     */
    @ApiOperation("获得所有收藏Store")
    @GetMapping("/store")
    public List<StoreVO> getCollectStores(HttpServletRequest request) {
        Integer userId = userService.getUserByRequest(request).getUserId();
        return storeCollectionsService.getCollectStores(userId);
    }

    /**
     * 获得所有收藏Group
     * @param request
     * @return
     */
    @ApiOperation("获得所有收藏Group")
    @GetMapping("/group")
    public List<GroupCollectionVO> getCollectGroups(HttpServletRequest request) {
        Integer userId = userService.getUserByRequest(request).getUserId();
        return groupCollectionsService.getCollectStores(userId);
    }
}