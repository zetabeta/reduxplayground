package ch.checkbit.replayground.redux

import ch.checkbit.replayground.redux.base.*

class DefaultStore<S : State>(initialState: S, private val reducer: Reducer<S>) :
    Store<S> {

    private val subscribers = mutableListOf<StoreSubscriber<S>>()

    private var state: S = initialState
        set(value) {
            field = value
            subscribers.forEach { it(value) }
        }

    override fun dispatch(action: Action) {
        state = reducer.invoke(state, action)
    }

    override fun add(subscriber: StoreSubscriber<S>): Boolean {
        return subscribers.add(subscriber)
    }

    override fun remove(subscriber: StoreSubscriber<S>): Boolean {
        return subscribers.remove(subscriber)
    }

    override fun getCurrent(): S {
        return state
    }

}