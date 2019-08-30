package ch.checkbit.replayground.redux.base

typealias Reducer<S> = (S, Action) -> S

typealias StoreSubscriber <S> = (S) -> Unit