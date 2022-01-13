package com.tistory.devs0n.point.common

import com.fasterxml.uuid.Generators

abstract class AutoIdBaseEntity : BaseEntity(Generators.timeBasedGenerator().generate())
