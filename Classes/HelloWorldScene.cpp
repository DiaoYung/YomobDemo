//
//  Created by steve on 2017-5-6.
//  作者微信：steve@杨迪
//  QQ：243859264 邮箱：steve@lemon-jam.com
//

#include "HelloWorldScene.h"
#include "VisibleRect.h"
#include "cocosbuilder/CocosBuilder.h"
#include "TGSDKCocos2dxHelper.h"


USING_NS_CC;
USING_NS_CC_EXT;

Scene* HelloWorld::createScene()
{
    // 'scene' is an autorelease object
    auto scene = Scene::create();
    
    // 'layer' is an autorelease object
    auto layer = HelloWorld::create();

    // add layer as a child to scene
    scene->addChild(layer);

    // return the scene
    return scene;
}

void HelloWorld::onEnter(){
	Layer::onEnter();

	//调用广告函数
    if (yomob::TGSDKCocos2dxHelper::couldShowAd("zDM9PkekLLxmiVxLaS5")) {
            yomob::TGSDKCocos2dxHelper::showAd("zDM9PkekLLxmiVxLaS5");

    }



}

// on "init" you need to initialize your instance
bool HelloWorld::init()
{
    //////////////////////////////
    // 1. super init first
    if ( !Layer::init() )
    {
        return false;
    }
    
    Size visibleSize = Director::getInstance()->getVisibleSize();
    Vec2 origin = Director::getInstance()->getVisibleOrigin();

    this->setTouchEnabled(true);
    this->setTouchMode(Touch::DispatchMode::ONE_BY_ONE);

    Layer = Node::create();
    this->addChild(Layer,160);
    Sprite *bg = Sprite::create("HelloWorld.png");

    bg->setPosition(VisibleRect::center());


    Layer->addChild(bg);
    auto *listener = EventListenerTouchOneByOne::create();//创建一个触摸监听
    listener->setSwallowTouches(true);//设置不想向下传递触摸  true是不想 默认为false
    
    listener->onTouchBegan = [=](Touch* touch, Event* event){
        return true;
    };

    listener->onTouchMoved = [](Touch* touch, Event* event){
    };
    
    listener->onTouchEnded = [=](Touch* touch, Event* event){
    };
    
    _eventDispatcher->addEventListenerWithSceneGraphPriority(listener,Layer);
	{
        Scale9Sprite* btnNormal = Scale9Sprite::create("price_coin.png");

        LabelTTF* title = LabelTTF::create("看视频得金币","ws.ttf",13);

        ControlButton* price = ControlButton::create(title,btnNormal);

	    Layer->addChild(price);
	    price->setPosition(bg->getPosition().x,bg->getPosition().y-120);
	    price->setTitleColorForState(Color3B(255,255,255), Control::State::NORMAL);
	    price->addTargetWithActionForControlEvents(this, cccontrol_selector(HelloWorld::videoButton), Control::EventType::TOUCH_DOWN);


	}

	return true;

}

void HelloWorld::videoButton(Ref * sender, Control::EventType controlEvent){

		//调用广告函数,Button广告

        if (yomob::TGSDKCocos2dxHelper::couldShowAd("iA4viAkkwuEd7H0rCG7")) {
             yomob::TGSDKCocos2dxHelper::showAd("iA4viAkkwuEd7H0rCG7");
         }
}



void HelloWorld::menuCloseCallback(Ref* pSender)
{
    Director::getInstance()->end();

#if (CC_TARGET_PLATFORM == CC_PLATFORM_IOS)
    exit(0);
#endif
}
