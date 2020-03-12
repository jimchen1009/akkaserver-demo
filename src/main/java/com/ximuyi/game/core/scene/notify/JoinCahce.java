package com.ximuyi.game.core.scene.notify;

import com.ximuyi.game.core.scene.PosXYZ;
import com.ximuyi.game.core.sceneobject.ISceneObject;
import com.ximuyi.game.core.sceneobject.ObjectType;
import com.ximuyi.game.server.proto.ProtoScene;

public class JoinCahce extends NotifyCahce<ProtoScene.ProJoinScene> {

    private final ObjectType type;
    private final long uniqueId;
    private final PosXYZ posXYZ;

    public JoinCahce(ISceneObject object) {
        this.type = object.getType();
        this.uniqueId = object.getUniqueId();
        this.posXYZ = object.getPos();
    }

    @Override
    protected ProtoScene.ProJoinScene serialize(int inex) {
        ProtoScene.ProJoinScene.Builder builder = ProtoScene.ProJoinScene.newBuilder();
        return builder.setUniqueId(uniqueId).setType(type.defineId)
                .setPos(posXYZ.serialize()).build();
    }
}