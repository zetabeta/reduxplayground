package ch.checkbit.replayground.redux.base

interface Store<S : State> {

    fun dispatch(action: Action)
    fun add(subscriber: StoreSubscriber<S>): Boolean
    fun remove(subscriber: StoreSubscriber<S>): Boolean
    fun getCurrent(): S
}